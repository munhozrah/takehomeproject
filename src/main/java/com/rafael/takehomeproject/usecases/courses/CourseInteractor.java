package com.rafael.takehomeproject.usecases.courses;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.domain.courses.Course;
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
    public CourseDTO save(CourseDTO courseDTO) throws CourseCreationException {
        if (courseDTO.getId() == null)
            courseDTO.setId(UUID.randomUUID());

        var course = new Course(courseDTO.getId(), courseDTO.getCourseName(), courseDTO.getDuration());
        if (!course.isCourseDurationValid())
            throw new CourseCreationException(String.format("The max course duration should be %d weeks", Course.MAX_COURSE_DURATION_SIX_MONTHS));
        var courseDTOOpt = this.coursesDsGateway.findByCourseName(courseDTO.getCourseName());
        CourseDTO existingCourseDTO = null;
        if (courseDTOOpt.isEmpty())
            return this.coursesDsGateway.save(courseDTO);

        existingCourseDTO = courseDTOOpt.get();
        if (existingCourseDTO.getCourseName().equals(courseDTO.getCourseName()) && 
            !existingCourseDTO.getId().equals(courseDTO.getId()))
            throw new CourseCreationException("Course with the same name already exists");
        return this.coursesDsGateway.save(courseDTO);
    }

    @Override
    public void delete(UUID id) {
        this.coursesDsGateway.delete(id);
    }
}