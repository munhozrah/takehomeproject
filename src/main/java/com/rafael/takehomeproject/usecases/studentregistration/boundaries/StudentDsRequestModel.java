package com.rafael.takehomeproject.usecases.studentregistration.boundaries;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDsRequestModel {
    UUID id;
    String username;
    String firstName; 
    String lastName;
    LocalDateTime dtOfBirth; 
    String address;
    String email;
    String phoneNumber;
}