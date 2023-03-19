package com.rafael.takehomeproject.usecases.usercreation.boundaries;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    @NotNull
    String username;
    @NotNull
    char[] password;
    @NotNull
    String role;
}
