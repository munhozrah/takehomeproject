package com.rafael.takehomeproject.adapters.data.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_roles")
public class UserRoleDataMapper {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "role_name")
    private String roleName;
}
