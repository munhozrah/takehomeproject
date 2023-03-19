package com.rafael.takehomeproject.adapters.data.student;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDsRequestModel;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentRegistrationDsGateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JpaStudent implements StudentRegistrationDsGateway {
    private final JpaStudentRepository studentRepository;

    @Override
    public int existsByEmail(String email) {
        return studentRepository.existsByEmail("email");
    }

    @Override
    public void save(StudentDsRequestModel requestModel) {
        var studentDataMapper = new StudentDataMapper(requestModel.getId(), requestModel.getFirstName(), requestModel.getLastName(), requestModel.getDtOfBirth(), requestModel.getAddress(), requestModel.getEmail(), requestModel.getPhoneNumber());
        studentRepository.save(studentDataMapper);
    }
}