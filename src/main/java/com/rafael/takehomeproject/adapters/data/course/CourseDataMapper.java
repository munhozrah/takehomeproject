package com.rafael.takehomeproject.adapters.data.course;

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
@Table(name = "courses")
public class CourseDataMapper {
      @Id
      UUID id;
      @Column(name = "course_name")
      String courseName;
      @Column(name = "duration")
      int duration;
}
