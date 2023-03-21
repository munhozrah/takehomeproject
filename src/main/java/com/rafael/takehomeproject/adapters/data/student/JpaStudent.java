package com.rafael.takehomeproject.adapters.data.student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDsRequestModel;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentRegistrationDsGateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JpaStudent implements StudentRegistrationDsGateway {
    private final JpaStudentRepository studentRepository;

    @Override
    public int existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    @Override
    @Transactional
    public void save(StudentDsRequestModel requestModel) {
        var studentDataMapper = new StudentDataMapper(requestModel.getId(), requestModel.getUsername(), requestModel.getFirstName(), requestModel.getLastName(), requestModel.getDtOfBirth(), requestModel.getAddress(), requestModel.getEmail(), requestModel.getPhoneNumber());
        studentRepository.save(studentDataMapper);
    }

    @Override
    public StudentDsRequestModel findByUsername(String username) {
        var studentDataMapperOpt = this.studentRepository.findByUsername(username);
        if (studentDataMapperOpt.isPresent()) {
            var studentDataMapper = studentDataMapperOpt.get();
            return new StudentDsRequestModel(studentDataMapper.getId(), studentDataMapper.getUsername(), studentDataMapper.getFirstName(), studentDataMapper.getLastName(), studentDataMapper.getDtOfBirth(), studentDataMapper.getAddress(), studentDataMapper.getEmail(), studentDataMapper.getPhoneNumber());
        }
        return null;
    }
}