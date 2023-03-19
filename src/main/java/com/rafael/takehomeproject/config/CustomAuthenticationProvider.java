package com.rafael.takehomeproject.config;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.takehomeproject.adapters.data.user.JpaUser;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
@Transactional
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final JpaUser jpaUser;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var name = authentication.getName();
        var password = String.valueOf(authentication.getCredentials());// should not use string here
        try {
            var user = this.jpaUser.findByUsername(name);
            if (user != null && user.getPassword().equals(password))
                return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } catch (Exception e) {
            log.info(String.format("User %s does not exists", name));
            log.error(e.getStackTrace().toString());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
