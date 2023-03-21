package com.rafael.takehomeproject.usecases.studentregistration.boundaries;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    UUID id;
    @NotNull
    String username;
    @NotNull
    String firstName; 
    @NotNull
    String lastName;
    @NotNull
    LocalDateTime dtOfBirth; 
    @NotNull
    String address;
    @NotNull
    String email;
    @NotNull
    String phoneNumber;
    @NotNull
    char[] password;
}
