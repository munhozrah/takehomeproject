package com.rafael.takehomeproject.adapters.controllers.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationException;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDTO;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
public class StudentRegistrationController {
    private final StudentInputBoundary studentInputBoundary;

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> register(@RequestBody @Valid StudentDTO studentDTO) throws StudentRegistrationException, UserRegistrationException {
        var studentResponseDTO = this.studentInputBoundary.register(studentDTO);
        return ResponseEntity.ok(studentResponseDTO);
    }
    @GetMapping("/student/{username}")
    ResponseEntity<StudentDTO> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(studentInputBoundary.findByUsername(username));
    }
}
