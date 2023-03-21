package com.rafael.takehomeproject.usecasestestcases;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.rafael.takehomeproject.domain.students.StudentFactory;
import com.rafael.takehomeproject.domain.students.StudentImpl;
import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationException;
import com.rafael.takehomeproject.usecases.studentregistration.StudentRegistrationInteractor;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDTO;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentDsRequestModel;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentInputBoundary;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentRegistrationDsGateway;
import com.rafael.takehomeproject.usecases.usercreation.UserRegistrationException;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;

public class StudentRegistrationTests {
    StudentRegistrationDsGateway studentDsGateway = mock(StudentRegistrationDsGateway.class);
    StudentFactory studentFactory = mock(StudentFactory.class);
    UserInputBoundary userInputBoundary = mock(UserInputBoundary.class);
    StudentInputBoundary studentInputBoundary = new StudentRegistrationInteractor(studentDsGateway, studentFactory, userInputBoundary);

    @Test
    void givenExistingUserThrowStudentRegistrationException() {
        var studentDTO = new StudentDTO(UUID.randomUUID(), "rafael.munhoz", "Rafael", "Munhoz", LocalDateTime.now(), "143 SAINT PATRICK ST", "test@mail.com", "+5551996023525", "1234".toCharArray());
        when (studentDsGateway.existsByEmail(studentDTO.getEmail())).thenReturn(1);
        assertThrows(StudentRegistrationException.class, () -> studentInputBoundary.register(studentDTO), "Email already in use.");
        verify(studentDsGateway, times(1)).existsByEmail(studentDTO.getEmail());
	}
    
    @Test
    void givenNonExistingUserAndAgeUnder16ThrowStudentRegistrationException() {
        var studentDTO = new StudentDTO(UUID.randomUUID(), "rafael.munhoz", "Rafael", "Munhoz", LocalDateTime.now(), "143 SAINT PATRICK ST", "test@mail.com", "+5551996023525", "1234".toCharArray());
        when (studentDsGateway.existsByEmail(studentDTO.getEmail())).thenReturn(0);
        when (studentFactory.create(any(), any(), any(), any(), any(), any(), any(), any()))
        .thenReturn(new StudentImpl(studentDTO.getId(), studentDTO.getFirstName() + "." + studentDTO.getLastName(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getDtOfBirth(), studentDTO.getAddress(), studentDTO.getEmail(), studentDTO.getPhoneNumber()));
        assertThrows(StudentRegistrationException.class, () -> studentInputBoundary.register(studentDTO), "Students should be 16 or older to register.");
        verify(studentDsGateway, times(1)).existsByEmail(studentDTO.getEmail());
	}

    @Test
    void givenNonExistingUserAndAgeBiggerThan16Register() throws StudentRegistrationException, UserRegistrationException {
        var studentDTO = new StudentDTO(UUID.randomUUID(), "rafael.munhoz", "Rafael", "Munhoz", LocalDateTime.of(1987,12,18,8,34,15), "143 SAINT PATRICK ST", "test@mail.com", "+5551996023525", "1234".toCharArray());
        when (studentDsGateway.existsByEmail(studentDTO.getEmail())).thenReturn(0);
        when (studentFactory.create(any(), any(), any(), any(), any(), any(), any(), any()))
        .thenReturn(new StudentImpl(studentDTO.getId(), studentDTO.getFirstName() + "." + studentDTO.getLastName(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getDtOfBirth(), studentDTO.getAddress(), studentDTO.getEmail(), studentDTO.getPhoneNumber()));
        var studentDTOResponse = this.studentInputBoundary.register(studentDTO);
        verify(studentDsGateway, times(1)).existsByEmail(studentDTO.getEmail());
        verify(studentDsGateway, times(1)).save(any(StudentDsRequestModel.class));
        assertNotNull(studentDTOResponse.getId());
	}
}