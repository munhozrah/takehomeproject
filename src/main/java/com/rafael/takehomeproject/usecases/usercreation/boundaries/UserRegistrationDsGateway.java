package com.rafael.takehomeproject.usecases.usercreation.boundaries;

public interface UserRegistrationDsGateway {
    boolean existsByUsername(String username);
    void save(UserDsRequestModel requestModel);
}
