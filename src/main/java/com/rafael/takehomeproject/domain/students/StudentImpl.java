package com.rafael.takehomeproject.domain.students;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentImpl implements Student {
    UUID id;
    String username;
    String firstName; 
    String lastName;
    LocalDateTime dtOfBirth; 
    String address;
    String email;
    String phoneNumber;

    @Override
    public boolean isUnder16() {
        return this.dtOfBirth.until(LocalDateTime.now(), ChronoUnit.YEARS) < 16;
    }    
}
