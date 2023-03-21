package com.rafael.takehomeproject.adapters.controllers.courses;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.takehomeproject.usecases.courses.CourseCreationException;
import com.rafael.takehomeproject.usecases.courses.boundaries.CourseDTO;
import com.rafael.takehomeproject.usecases.courses.boundaries.CoursesInputBoundary;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("courses")
public class CourseController {
    private final CoursesInputBoundary coursesInputBoundary;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> listAll() {
        var coursesDTOList = this.coursesInputBoundary.listAll();
        return ResponseEntity.ok(coursesDTOList);
    }

    @PutMapping
    public ResponseEntity<CourseDTO> update(@RequestBody CourseDTO courseDTO) throws CourseCreationException {
        return ResponseEntity.ok(this.coursesInputBoundary.save(courseDTO));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> insert(@RequestBody CourseDTO courseDTO) throws CourseCreationException {
        return ResponseEntity.ok(this.coursesInputBoundary.save(courseDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UUID> delete(@PathVariable UUID id) {
        this.coursesInputBoundary.delete(id);
        return ResponseEntity.ok(id);
    }
}