package com.rafael.takehomeproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers(headers -> headers
                .frameOptions()
                .disable());
        http.csrf().disable();
        http.authorizeHttpRequests()
        .requestMatchers("/h2-console/**")
        .permitAll()
        .requestMatchers("/user/**")
        .permitAll()
        .anyRequest()
        .permitAll();
        return http.build();
    }
}