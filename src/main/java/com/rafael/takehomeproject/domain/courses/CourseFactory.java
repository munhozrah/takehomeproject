package com.rafael.takehomeproject.domain.courses;

import java.util.UUID;

public interface CourseFactory {
    Course create(UUID id, String courseName, int duration);
}
