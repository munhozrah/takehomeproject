package com.rafael.takehomeproject.usecases.studentregistration.boundaries;

public interface StudentRegistrationDsGateway {
    boolean existsByEmail(String email);
    boolean save(StudentDsRequestModel requestModel);
}

