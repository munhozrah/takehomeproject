package com.rafael.takehomeproject.usecases.courses.boundaries;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {
    UUID id;
    String courseName;
}
