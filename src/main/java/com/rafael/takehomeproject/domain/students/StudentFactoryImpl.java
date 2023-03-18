package com.rafael.takehomeproject.domain.students;

import java.time.LocalDateTime;
import java.util.UUID;

public class StudentFactoryImpl implements StudentFactory {

    @Override
    public Student create(UUID id, String username, String firstName, String lastName, LocalDateTime dtOfBirth,
            String address, String email, String phoneNumber) {
        return new StudentImpl(id, username, firstName, lastName, dtOfBirth, address, email, phoneNumber);
    }    
}
