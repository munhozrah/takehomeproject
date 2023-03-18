package com.rafael.takehomeproject.usecases.studentregistration.boundaries;

import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationException;

public interface StudentInputBoundary {
    StudentDTO register(StudentDTO requestModel) throws StudentRegistrationException;
}
