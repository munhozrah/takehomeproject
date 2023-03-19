package com.rafael.takehomeproject.usecases.login.boundaries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginDsRequestModel {
    String username;
    String password;
}
