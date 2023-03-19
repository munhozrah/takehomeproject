package com.rafael.takehomeproject.usecases.studentregistration;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.domain.students.StudentFactory;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDTO;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDsRequestModel;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentInputBoundary;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentRegistrationDsGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class StudentRegistrationInteractor implements StudentInputBoundary {
    private final StudentRegistrationDsGateway studentDsGateway;
    private final StudentFactory studentFactory;        
        @Override
        public StudentDTO register(StudentDTO requestModel) throws StudentRegistrationException {
            if (studentDsGateway.existsByEmail(requestModel.getEmail()) > 0)
                throw new StudentRegistrationException("Email already in use.");
            var student = studentFactory.create(
                UUID.randomUUID(), 
                requestModel.getFirstName() + "." + requestModel.getLastName(), 
                requestModel.getFirstName(), 
                requestModel.getLastName(), 
                requestModel.getDtOfBirth(), 
                requestModel.getAddress(), 
                requestModel.getEmail(), 
                requestModel.getPhoneNumber());
            if (student.isUnder16())
                throw new StudentRegistrationException("Students should be 16 or older to register.");
            var studentDsModel = new StudentDsRequestModel(student.getId(), student.getUsername(), student.getFirstName(), student.getLastName(), student.getDtOfBirth(), student.getAddress(), student.getEmail(), student.getPhoneNumber());
            studentDsGateway.save(studentDsModel);
            requestModel.setId(student.getId());
            return requestModel;
        }
}
