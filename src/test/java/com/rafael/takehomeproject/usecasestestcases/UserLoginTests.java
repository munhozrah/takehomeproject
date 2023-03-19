package com.rafael.takehomeproject.usecasestestcases;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.security.auth.login.LoginException;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;

import com.rafael.takehomeproject.domain.users.UserFactory;
import com.rafael.takehomeproject.usecases.login.UserLoginInteractor;
import com.rafael.takehomeproject.usecases.login.boundaries.UserLoginDsRequestModel;
import com.rafael.takehomeproject.usecases.login.boundaries.UserLoginInputBoudary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsGateway;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsRequestModel;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;

public class UserLoginTests {
    UserDsGateway userDsGateway = mock(UserDsGateway.class);
    UserLoginInputBoudary userLoginInputBoudary = new UserLoginInteractor(userDsGateway);

    @Test
    void givenRightCredentialsThenReturnUserRequestWithRole() throws LoginException {
        var userRequestDTO = new UserRequestDTO("username", new char[16], null);
        when (userDsGateway.login(any(UserLoginDsRequestModel.class))).thenReturn(true);
        when (userDsGateway.findByUsername(userRequestDTO.getUsername())).thenReturn(new UserDsRequestModel("username", "encrypted stuff", null, "ADMIN"));
        var userResponseRequestDTO = userLoginInputBoudary.login(userRequestDTO);
        verify(userDsGateway, times(1)).login(any(UserLoginDsRequestModel.class));
        verify(userDsGateway, times(1)).findByUsername(userRequestDTO.getUsername());
        assertNotNull(userResponseRequestDTO.getRole());
	}

    @Test
    void givenWrongCredentialsThenThrowLoginException() {
        var userRequestDTO = new UserRequestDTO("username", new char[16], null);
        when (userDsGateway.login(any(UserLoginDsRequestModel.class))).thenReturn(false);
        assertThrows(LoginException.class, () -> userLoginInputBoudary.login(userRequestDTO), "User or password not found");
        verify(userDsGateway, times(1)).login(any(UserLoginDsRequestModel.class));
}

}
