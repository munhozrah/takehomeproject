package com.rafael.takehomeproject.usecases.studentregistration.boundaries;

public interface StudentRegistrationDsGateway {
    int existsByEmail(String email);
    void save(StudentDsRequestModel requestModel);
    StudentDsRequestModel findByUsername(String username);
}

