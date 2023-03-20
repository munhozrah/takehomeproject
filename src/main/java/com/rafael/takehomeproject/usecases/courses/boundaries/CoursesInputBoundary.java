package com.rafael.takehomeproject.usecases.courses.boundaries;

import java.util.List;
import java.util.UUID;

public interface CoursesInputBoundary {
    List<CourseDTO> listAll();
    CourseDTO save(CourseDTO courseDTO);
    void delete(UUID id);
}
