package com.rafael.takehomeproject.adapters.data.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.usecases.courses.boundaries.CourseDTO;
import com.rafael.takehomeproject.usecases.courses.boundaries.CoursesDsGateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JpaCourse implements CoursesDsGateway {
    private final JpaCourseRepository courseRepository;
    @Override
    public List<CourseDTO> listAll() {
        var list = this.courseRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        list.forEach(course -> {
            courseDTOList.add(new CourseDTO(course.getId(), course.getCourseName()));
        });
        return courseDTOList;
    }
}
