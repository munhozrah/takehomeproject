package com.rafael.takehomeproject.adapters.data.course;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends CrudRepository<CourseDataMapper, UUID>{}
