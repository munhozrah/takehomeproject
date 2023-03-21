package com.rafael.takehomeproject.domain.users;

public interface User {
    public static final int MINIMUM_LENGTH_PASSWD = 4;
    boolean passwordIsValid();
    String getUsername();
    char[] getPassword();
}
