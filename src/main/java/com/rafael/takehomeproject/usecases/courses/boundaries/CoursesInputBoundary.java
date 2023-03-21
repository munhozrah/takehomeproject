package com.rafael.takehomeproject.usecases.courses.boundaries;

import java.util.List;
import java.util.UUID;

import com.rafael.takehomeproject.usecases.courses.CourseCreationException;

public interface CoursesInputBoundary {
    List<CourseDTO> listAll();
    CourseDTO save(CourseDTO courseDTO) throws CourseCreationException;
    void delete(UUID id);
}
