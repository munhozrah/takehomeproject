package com.rafael.takehomeproject.domaintestcases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.rafael.takehomeproject.domain.users.CommonUserFactory;

public class UsersTests {
    @Test
    void nullGivenPassordShouldReturnFalse() {
        var userFactory = new CommonUserFactory();
        var commonUser = userFactory.create("Rafael", null);
        assertFalse(commonUser.passwordIsValid());
	}
    
    @Test
    void weakGivenPassordShouldReturnFalse() {
        var userFactory = new CommonUserFactory();
        var commonUser = userFactory.create("Rafael", new char[15]);
        assertFalse(commonUser.passwordIsValid());
	}

    @Test
    void strongGivenPassordShouldReturnTrue() {
        var userFactory = new CommonUserFactory();
        var commonUser = userFactory.create("Rafael", new char[16]);
        assertTrue(commonUser.passwordIsValid());
	}
}
