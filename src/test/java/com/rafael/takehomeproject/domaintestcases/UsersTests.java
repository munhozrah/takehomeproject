package com.rafael.takehomeproject.domaintestcases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.rafael.takehomeproject.domain.users.CommonUserFactory;
import com.rafael.takehomeproject.domain.users.User;

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
        var commonUser = userFactory.create("Rafael", new char[User.MINIMUM_LENGTH_PASSWD - 1]);
        assertFalse(commonUser.passwordIsValid());
	}

    @Test
    void strongGivenPassordShouldReturnTrue() {
        var userFactory = new CommonUserFactory();
        var commonUser = userFactory.create("Rafael", new char[User.MINIMUM_LENGTH_PASSWD]);
        assertTrue(commonUser.passwordIsValid());
	}
}
