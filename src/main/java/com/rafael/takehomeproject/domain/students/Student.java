package com.rafael.takehomeproject.domain.students;

import java.time.LocalDateTime;
import java.util.UUID;

public interface Student {
    public boolean isUnder16();
    public UUID getId();
    public String getUsername();
    public String getFirstName();
    public String getLastName();
    public LocalDateTime getDtOfBirth();
    public String getAddress();
    public String getEmail();
    public String getPhoneNumber();
}
