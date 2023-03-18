package com.rafael.takehomeproject.domain.users;

import org.springframework.stereotype.Component;

@Component
public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username, char[] password) {
        return new CommonUser(username, password);
    } 
}
