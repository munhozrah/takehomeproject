package com.rafael.takehomeproject.domain.courses;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    UUID id;
    String courseName;
}
