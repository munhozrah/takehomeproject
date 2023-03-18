package com.rafael.takehomeproject.domain.users;

public interface UserFactory {
    User create(String username, char[] password);
}