package com.rafael.takehomeproject.adapters.controllers.user;

import javax.security.auth.login.LoginException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.takehomeproject.usecases.login.boundaries.UserLoginInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private final UserInputBoundary userInputBoundary;
    private final UserLoginInputBoundary userLoginInputBoundary;
    
    @PostMapping("/user")
    ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userRequestDTO) throws UserRegistrationException {
        return ResponseEntity.ok(userInputBoundary.create(userRequestDTO));
    }

    @PostMapping("/user/login")
    ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO) throws UserRegistrationException, LoginException {
        return ResponseEntity.ok(userLoginInputBoundary.login(userRequestDTO));
    }
}
