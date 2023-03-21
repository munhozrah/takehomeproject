package com.rafael.takehomeproject.usecases.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class CourseCreationException extends Exception {
    String errorMessage;
}
