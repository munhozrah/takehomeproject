package com.rafael.takehomeproject.adapters.controllers.userregistration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserRegistrationController {
    private final UserInputBoundary userInputBoundary;
    
    @PostMapping("/user")
    ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userRequestDTO) throws UserRegistrationException {
        return ResponseEntity.ok(userInputBoundary.create(userRequestDTO));
    }
}
