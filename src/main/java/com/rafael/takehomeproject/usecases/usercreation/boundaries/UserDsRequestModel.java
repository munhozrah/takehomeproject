package com.rafael.takehomeproject.usecases.usercreation.boundaries;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDsRequestModel {
    String username;
    String password;
    LocalDateTime dtCreation;
    String role;
}