package com.rafael.takehomeproject.usecases.studentregistration;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class StudentRegistrationException extends Exception {
    String errorMessage;
}
