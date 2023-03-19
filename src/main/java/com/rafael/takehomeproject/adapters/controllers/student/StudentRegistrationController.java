package com.rafael.takehomeproject.adapters.controllers.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationException;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDTO;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentInputBoundary;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
public class StudentRegistrationController {
    private final StudentInputBoundary studentInputBoundary;

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> register(@RequestBody StudentDTO studentDTO) throws StudentRegistrationException {
        var studentResponseDTO = this.studentInputBoundary.register(studentDTO);
        return ResponseEntity.ok(studentResponseDTO);
    }
}
