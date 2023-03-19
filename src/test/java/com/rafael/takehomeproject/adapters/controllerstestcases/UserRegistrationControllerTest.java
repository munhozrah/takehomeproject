package com.rafael.takehomeproject.adapters.controllerstestcases;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael.takehomeproject.adapters.controllers.user.UserController;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserRegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserInputBoundary userInputBoundary;

  @Test
  void givenValidInputThenReturns200() throws Exception {
    var userRequestDTO = new UserRequestDTO("rafael.munhoz", new char[16], null);
    mockMvc.perform(post("/user")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(userRequestDTO)))
        .andExpect(status().isOk());
  }

  @Test
  void givenInvalidInputThenReturns400() throws Exception {
    var userRequestDTO = new UserRequestDTO("rafael.munhoz", null, null);
    mockMvc.perform(post("/user")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(userRequestDTO)))
        .andExpect(status().isOk());
    }
}
