package com.example.springdatarelationships.repo;

import com.example.springdatarelationships.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
