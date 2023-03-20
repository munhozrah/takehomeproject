package com.rafael.takehomeproject.usecases.courses;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.usecases.courses.boundaries.CourseDTO;
import com.rafael.takehomeproject.usecases.courses.boundaries.CoursesDsGateway;
import com.rafael.takehomeproject.usecases.courses.boundaries.CoursesInputBoundary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseInteractor implements CoursesInputBoundary {
    private final CoursesDsGateway coursesDsGateway;

    @Override
    public List<CourseDTO> listAll() {
        return this.coursesDsGateway.listAll(); //they are sharing the same model with id and courseName
    }
    
    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        if (courseDTO.getId() == null)
            courseDTO.setId(UUID.randomUUID());
        return this.coursesDsGateway.save(courseDTO);
    }

    @Override
    public void delete(UUID id) {
        this.coursesDsGateway.delete(id);
    }
}