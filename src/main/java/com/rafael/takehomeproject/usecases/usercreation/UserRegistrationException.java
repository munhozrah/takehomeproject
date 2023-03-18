package com.rafael.takehomeproject.usecases.usercreation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRegistrationException extends Exception {
    String errorMessage;
}
