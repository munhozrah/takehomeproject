package com.rafael.takehomeproject.adapters.data.user;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "users")
public class UserDataMapper {
    @Id
    @Column(name = "username")
    String username;
    
    @Column(name = "passwd")
    String password;
    
    @Column(name = "dt_creation")
    LocalDateTime dtCreation;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = true, insertable = true, updatable = true)
    UserRoleDataMapper userRole;
}
