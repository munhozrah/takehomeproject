package com.rafael.takehomeproject.drivers;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.courses.CourseCreationException;
import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler( UserRegistrationException.class )
  public final ResponseEntity<String> handleAllExceptions(UserRegistrationException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler( CourseCreationException.class )
  public final ResponseEntity<String> handleAllExceptions(CourseCreationException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler( StudentRegistrationException.class)
  public final ResponseEntity<String> handleAllExceptions(StudentRegistrationException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler({ LoginException.class })
  public final ResponseEntity<String> handleAllExceptions(LoginException ex, WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler({ Exception.class })
  public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
    return new ResponseEntity<>("Something unexpected happened and we don't know how to deal with it yet", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
