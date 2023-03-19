package com.rafael.takehomeproject.adapters.data.student;


import java.time.LocalDateTime;
import java.util.UUID;

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
    String firstName; 
    String lastName;
    LocalDateTime dtOfBirth; 
    String address;
    String email;
    String phoneNumber;
}
