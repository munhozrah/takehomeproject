package com.rafael.takehomeproject.drivers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler({ UserRegistrationException.class, StudentRegistrationException.class })
  public final ResponseEntity<String> handleAllExceptions(UserRegistrationException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }
}
