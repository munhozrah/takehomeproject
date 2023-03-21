package com.rafael.takehomeproject.usecasestestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.rafael.takehomeproject.domain.users.CommonUser;
import com.rafael.takehomeproject.domain.users.User;
import com.rafael.takehomeproject.domain.users.UserFactory;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationInteractor;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsGateway;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

public class UserCreationTests {
    UserDsGateway userDsGateway = mock(UserDsGateway.class);
    UserFactory userFactory = mock(UserFactory.class);
    UserInputBoundary userInputBoundary = new UserRegistrationInteractor(userDsGateway, userFactory);

    @Test
    void givenExistingUserAndAnyPassordThenInvokePrepareFailView() {
        var userRequestDTO = new UserRequestDTO("Test", new char[User.MINIMUM_LENGTH_PASSWD], null);
        when (userDsGateway.existsByUsername(userRequestDTO.getUsername())).thenReturn(true);
        when (userFactory.create(userRequestDTO.getUsername(), userRequestDTO.getPassword())).thenReturn(new CommonUser(userRequestDTO.getUsername(), userRequestDTO.getPassword()));
        assertThrows(UserRegistrationException.class, () -> userInputBoundary.create(userRequestDTO), "User already exists.");
        verify(userDsGateway, times(1)).existsByUsername(userRequestDTO.getUsername());
	}

    @Test
    void givenNonExistingUserAndWeakPassordThenInvokePrepareFailView() {
        var randomPassord = new char[User.MINIMUM_LENGTH_PASSWD - 1];
        var userRequestDTO = new UserRequestDTO("Test", randomPassord, null);
        when (userDsGateway.existsByUsername(userRequestDTO.getUsername())).thenReturn(false);
        when (userFactory.create(userRequestDTO.getUsername(), userRequestDTO.getPassword())).thenReturn(new CommonUser(userRequestDTO.getUsername(), userRequestDTO.getPassword()));
        assertThrows(UserRegistrationException.class, () -> userInputBoundary.create(userRequestDTO), String.format("User password must have more than %d characters.", User.MINIMUM_LENGTH_PASSWD));
        verify(userDsGateway, times(1)).existsByUsername(userRequestDTO.getUsername());
	}

    @Test
    void givenTestUserAndValidPassordThenSaveItAndInvokePrepareSuccessView() throws UserRegistrationException {
        var userRequestDTO = new UserRequestDTO("Test", new char[User.MINIMUM_LENGTH_PASSWD], null);
        when (userDsGateway.existsByUsername(userRequestDTO.getUsername())).thenReturn(false);
        when (userFactory.create(userRequestDTO.getUsername(), userRequestDTO.getPassword())).thenReturn(new CommonUser(userRequestDTO.getUsername(), userRequestDTO.getPassword()));
        var userResponseDTO = userInputBoundary.create(userRequestDTO);
        verify(userDsGateway, times(1)).existsByUsername(userRequestDTO.getUsername());
        assertEquals(new UserResponseDTO(userRequestDTO.getUsername(), null), userResponseDTO);
	}
}
