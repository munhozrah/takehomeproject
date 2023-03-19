package com.rafael.takehomeproject.adapters.data.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends CrudRepository <UserDataMapper, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM users usr WHERE usr.username = ?1" )
    UserDataMapper findByUsername(String username);
}
