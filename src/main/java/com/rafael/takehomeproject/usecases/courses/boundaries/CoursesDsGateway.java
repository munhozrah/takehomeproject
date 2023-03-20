package com.rafael.takehomeproject.usecases.courses.boundaries;

import java.util.List;
import java.util.UUID;

public interface CoursesDsGateway {
    List<CourseDTO> listAll();
    CourseDTO save(CourseDTO courseDTO);
    void delete(UUID id);
}
