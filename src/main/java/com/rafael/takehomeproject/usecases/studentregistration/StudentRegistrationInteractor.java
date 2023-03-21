package com.rafael.takehomeproject.usecases.studentregistration;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.domain.students.StudentFactory;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDTO;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDsRequestModel;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentInputBoundary;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentRegistrationDsGateway;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationInteractor;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class StudentRegistrationInteractor implements StudentInputBoundary {
    private final StudentRegistrationDsGateway studentDsGateway;
    private final StudentFactory studentFactory;        
    private final UserInputBoundary userInputBoundary;
        @Override
        public StudentDTO register(StudentDTO studentDTO) throws StudentRegistrationException {
            if (studentDsGateway.existsByEmail(studentDTO.getEmail()) > 0) {
                throw new StudentRegistrationException("Email already in use.");
            }
            var student = studentFactory.create(
                UUID.randomUUID(), 
                studentDTO.getFirstName().toLowerCase() + "." + studentDTO.getLastName().toLowerCase(), 
                studentDTO.getFirstName(), 
                studentDTO.getLastName(), 
                studentDTO.getDtOfBirth(), 
                studentDTO.getAddress(), 
                studentDTO.getEmail(), 
                studentDTO.getPhoneNumber());
            if (student.isUnder16())
                throw new StudentRegistrationException("Students should be 16 or older to register.");
            try {
                userInputBoundary.create(new UserRequestDTO(studentDTO.getUsername(), studentDTO.getPassword(), "STUDENT"));
            } catch(UserRegistrationException e) { //it can throw the same exception for weak passwords
                log.debug("Student already has an user");
            }
            var studentDsModel = new StudentDsRequestModel(student.getId(), student.getUsername(), student.getFirstName(), student.getLastName(), student.getDtOfBirth(), student.getAddress(), student.getEmail(), student.getPhoneNumber());
            studentDsGateway.save(studentDsModel);
            log.info(String.format("Student %s registered", student.getId().toString()));
            studentDTO.setId(student.getId());
            return studentDTO;
        }
        
    @Override
    public StudentDTO findByUsername(String username) {
         var userDs = this.studentDsGateway.findByUsername(username);
         return new StudentDTO(userDs.getId(), userDs.getUsername(), userDs.getFirstName(), userDs.getLastName(), userDs.getDtOfBirth(), userDs.getAddress(), userDs.getEmail(), userDs.getPhoneNumber(), null);
    }
}