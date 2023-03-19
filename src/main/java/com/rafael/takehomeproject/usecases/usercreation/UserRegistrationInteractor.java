package com.rafael.takehomeproject.usecases.usercreation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.domain.users.UserFactory;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsRequestModel;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsGateway;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class UserRegistrationInteractor implements UserInputBoundary{
    private final UserDsGateway userDsGateway;
    private final UserFactory userFactory;

    @Override
    public UserResponseDTO create(UserRequestDTO requestModel) throws UserRegistrationException {
        if (userDsGateway.existsByUsername(requestModel.getUsername()))
            throw new UserRegistrationException("User already exists.");
        var user = userFactory.create(requestModel.getUsername(), requestModel.getPassword());
        if (!user.passwordIsValid())
            throw new UserRegistrationException("User password must have more than 16 characters.");
        var now = LocalDateTime.now();
        var userDsModel = new UserDsRequestModel(user.getUsername(), encryptPassord(user.getPassword()), now, requestModel.getRole());

        userDsGateway.save(userDsModel);

        return new UserResponseDTO(user.getUsername(), requestModel.getRole());
    }

    private String encryptPassord(char[] passwd) {
        return String.valueOf(passwd);
    }
}