package com.rafael.takehomeproject.domaintestcases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.rafael.takehomeproject.domain.students.StudentFactoryImpl;

public class StudentTests {
    @Test
    void givenAgeLessThan16ShouldReturnTrue() {
        var studentFactory = new StudentFactoryImpl();
        var student = studentFactory.create(null, null, null, null, LocalDateTime.of (LocalDateTime.now().getYear() - 15, 12, 18, 8, 35, 9), null, null, null);
        assertTrue(student.isUnder16());
	}
    
    @Test
    void givenAgeGreaterOrEqualTo16ShouldReturnFalse() {
        var studentFactory = new StudentFactoryImpl();
        var student = studentFactory.create(null, null, null, null, LocalDateTime.of (LocalDateTime.now().getYear() - 17, 12, 18, 8, 35, 9), null, null, null);
        assertFalse(student.isUnder16());
	}
}