package com.rafael.takehomeproject.adapters.data.course;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends CrudRepository<CourseDataMapper, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM courses c WHERE c.course_name = ?1")
    Optional<CourseDataMapper> findByCourseName(String courseName);
}
