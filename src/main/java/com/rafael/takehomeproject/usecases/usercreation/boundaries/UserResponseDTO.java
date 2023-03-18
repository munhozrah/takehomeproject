package com.rafael.takehomeproject.usecases.usercreation.boundaries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    String username;
    String creationTime;
}