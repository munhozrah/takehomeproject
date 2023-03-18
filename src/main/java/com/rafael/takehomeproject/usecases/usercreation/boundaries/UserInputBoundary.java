package com.rafael.takehomeproject.usecases.usercreation.boundaries;

import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;

public interface UserInputBoundary {
    UserResponseDTO create(UserRequestDTO requestModel) throws UserRegistrationException;
}
