package com.rafael.takehomeproject.usecases.login;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.usecases.login.boundaries.UserLoginDsRequestModel;
import com.rafael.takehomeproject.usecases.login.boundaries.UserLoginInputBoudary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsGateway;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class UserLoginInteractor implements UserLoginInputBoudary {
    private final UserDsGateway userDsGateway;

    @Override
    public UserResponseDTO login(UserRequestDTO userRequestDTO) throws LoginException {
        if (!this.userDsGateway.login(new UserLoginDsRequestModel(userRequestDTO.getUsername(), encryptPassord(userRequestDTO.getPassword()))))
            throw new LoginException("User or password not valid");
        var user = this.userDsGateway.findByUsername(userRequestDTO.getUsername());
        return new UserResponseDTO(userRequestDTO.getUsername(), user.getRole());
    }

    private String encryptPassord(char[] passwd) {
        return String.valueOf(passwd);
    }
}