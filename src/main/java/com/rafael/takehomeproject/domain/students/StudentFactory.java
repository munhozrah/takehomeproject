package com.rafael.takehomeproject.domain.students;

import java.time.LocalDateTime;
import java.util.UUID;

public interface StudentFactory {
    Student create(UUID id, String username, String firstName, String lastName, LocalDateTime dtOfBirth,
            String address, String email, String phoneNumber);
}
