package com.rafael.takehomeproject.adapters.data.user;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsRequestModel;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRegistrationDsGateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JpaUser implements UserRegistrationDsGateway {
    private final JpaUserRepository jpaUserRepository;

    @Override
    public boolean existsByUsername(String username) {
        return jpaUserRepository.existsById(username);
    }

    @Override
    public void save(UserDsRequestModel requestModel) {
        var userDataMapper = new UserDataMapper(requestModel.getName(), requestModel.getPassword(), LocalDateTime.now());
        jpaUserRepository.save(userDataMapper);
    }
    
}
