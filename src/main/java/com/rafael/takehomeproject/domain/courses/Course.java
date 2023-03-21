package com.rafael.takehomeproject.domain.courses;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    public static final int MAX_COURSE_DURATION_SIX_MONTHS = 6;
    UUID id;
    String courseName;
    int duration;

    public boolean isCourseDurationValid() {
        return this.duration <= MAX_COURSE_DURATION_SIX_MONTHS;
    }
}
