package com.rafael.takehomeproject.adapters.data.student;


import java.time.LocalDateTime;
import java.util.UUID;

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
@Table(name = "students")
public class StudentDataMapper {
    @Id
    UUID id;
    @Column(name = "username")
    String username;
    @Column(name = "first_name")
    String firstName; 
    @Column(name = "last_name")
    String lastName;
    @Column(name = "dob")
    LocalDateTime dtOfBirth; 
    @Column(name = "addr")
    String address;
    @Column(name = "email")
    String email;
    @Column(name = "phone_number")
    String phoneNumber;
}
