package com.rafael.takehomeproject.adapters.data.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRoleRepository extends CrudRepository <UserRoleDataMapper, String> {}