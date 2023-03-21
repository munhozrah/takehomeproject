package com.rafael.takehomeproject.domain.courses;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CourseFactoryImpl implements CourseFactory {

    @Override
    public Course create(UUID id, String courseName, int duration) {
        return new Course(id, courseName, duration);
    }   
}
