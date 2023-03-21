package com.rafael.takehomeproject.usecases.studentregistration.boundaries;

import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationException;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;

public interface StudentInputBoundary {
    StudentDTO register(StudentDTO requestModel) throws StudentRegistrationException, UserRegistrationException;
    StudentDTO findByUsername(String username);
}
