package com.rafael.takehomeproject.usecases.courses;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.usecases.courses.boundaries.CourseDTO;
import com.rafael.takehomeproject.usecases.courses.boundaries.CoursesDsGateway;
import com.rafael.takehomeproject.usecases.courses.boundaries.CoursesInputBoundary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseListingInteractor implements CoursesInputBoundary{
    private final CoursesDsGateway coursesDsGateway;

    @Override
    public List<CourseDTO> listAll() {
        return this.coursesDsGateway.listAll(); //they are sharing the same model with id and courseName
    }
    
}
