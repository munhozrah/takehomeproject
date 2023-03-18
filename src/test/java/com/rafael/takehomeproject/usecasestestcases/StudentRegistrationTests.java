package com.rafael.takehomeproject.usecasestestcases;

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
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentInputBoundary;
import com.rafael.takehomeproject.usecases.studentregistration.boundaries.StudentRegistrationDsGateway;

public class StudentRegistrationTests {
    StudentRegistrationDsGateway studentDsGateway = mock(StudentRegistrationDsGateway.class);
    StudentFactory studentFactory = mock(StudentFactory.class);
    StudentInputBoundary studentInputBoundary = new StudentRegistrationInteractor(studentDsGateway, studentFactory);

    @Test
    void givenExistingUserThrowStudentRegistrationException() {
        var studentDTO = new StudentDTO(UUID.randomUUID(), "Rafael", "Munhoz", LocalDateTime.now(), "143 SAINT PATRICK ST", "test@mail.com", "+5551996023525");
        when (studentDsGateway.existsByEmail(studentDTO.getEmail())).thenReturn(true);
        assertThrows(StudentRegistrationException.class, () -> studentInputBoundary.register(studentDTO), "Email already in use.");
        verify(studentDsGateway, times(1)).existsByEmail(studentDTO.getEmail());
	}
    @Test
    void givenNonExistingUserAndAgeUnder16ThrowStudentRegistrationException() {
        var studentDTO = new StudentDTO(UUID.randomUUID(), "Rafael", "Munhoz", LocalDateTime.now(), "143 SAINT PATRICK ST", "test@mail.com", "+5551996023525");
        when (studentDsGateway.existsByEmail(studentDTO.getEmail())).thenReturn(false);
        when (studentFactory.create(any(), any(), any(), any(), any(), any(), any(), any()))
        .thenReturn(new StudentImpl(studentDTO.getId(), studentDTO.getFirstName() + "." + studentDTO.getLastName(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getDtOfBirth(), studentDTO.getAddress(), studentDTO.getEmail(), studentDTO.getPhoneNumber()));
        assertThrows(StudentRegistrationException.class, () -> studentInputBoundary.register(studentDTO), "Students should be 16 or older to register.");
        verify(studentDsGateway, times(1)).existsByEmail(studentDTO.getEmail());
	}
}