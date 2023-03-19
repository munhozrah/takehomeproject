package com.rafael.takehomeproject.adapters.controllers.courses;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.takehomeproject.usecases.courses.boundaries.CourseDTO;
import com.rafael.takehomeproject.usecases.courses.boundaries.CoursesInputBoundary;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
public class CourseController {
    private final CoursesInputBoundary coursesInputBoundary;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> listAll() {
        var coursesDTOList = this.coursesInputBoundary.listAll();
        return ResponseEntity.ok(coursesDTOList);
    }
}