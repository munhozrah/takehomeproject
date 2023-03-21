package com.rafael.takehomeproject.adapters.data.user;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.takehomeproject.usecases.login.boundaries.UserLoginDsRequestModel;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsRequestModel;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsGateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JpaUser implements UserDsGateway {
    private final JpaUserRepository jpaUserRepository;
    private final JpaUserRoleRepository jpaUserRoleRepository;

    @Override
    public boolean existsByUsername(String username) {
        return jpaUserRepository.existsById(username);
    }

    @Override
    @Transactional
    public void save(UserDsRequestModel requestModel) {
        var userDataMapper = new UserDataMapper(requestModel.getUsername(), requestModel.getPassword(), LocalDateTime.now(), null);
        this.jpaUserRepository.save(userDataMapper);
        var userRoleDataMapper = new UserRoleDataMapper(requestModel.getUsername(), requestModel.getRole());
        this.jpaUserRoleRepository.save(userRoleDataMapper);
    }

    @Override
    public boolean login(UserLoginDsRequestModel requestModel) {
        try {
            var user = jpaUserRepository.findByUsername(requestModel.getUsername());
            if (requestModel.getPassword().equals(user.getPassword()))
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public UserDsRequestModel findByUsername(String username) {
        var user = jpaUserRepository.findByUsername(username);
        return new UserDsRequestModel(user.getUsername(), user.getPassword(), user.getDtCreation(), user.getUserRole().getRoleName());
    }
}
