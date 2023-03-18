package com.rafael.takehomeproject.domain.users;

public interface User {
    boolean passwordIsValid();
    String getUsername();
    char[] getPassword();
}
