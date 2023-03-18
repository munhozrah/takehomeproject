package com.rafael.takehomeproject.usecases.studentregistration.boundaries;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    @NotNull
    UUID id;
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
}
