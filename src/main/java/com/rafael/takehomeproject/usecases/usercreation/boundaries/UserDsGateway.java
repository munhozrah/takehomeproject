package com.rafael.takehomeproject.usecases.usercreation.boundaries;

import com.rafael.takehomeproject.usecases.login.boundaries.UserLoginDsRequestModel;

public interface UserDsGateway {
    boolean existsByUsername(String username);
    void save(UserDsRequestModel requestModel);
    boolean login(UserLoginDsRequestModel requestModel);
    UserDsRequestModel findByUsername(String username);
}
