package com.rafael.takehomeproject.usecases.login.boundaries;

import javax.security.auth.login.LoginException;

import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

public interface UserLoginInputBoudary {
    UserResponseDTO login(UserRequestDTO userRequestDTO) throws LoginException;
}
