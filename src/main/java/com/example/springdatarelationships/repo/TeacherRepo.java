package com.example.springdatarelationships.repo;

import com.example.springdatarelationships.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
}
