package com.example.springdatarelationships.repo;

import com.example.springdatarelationships.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {
}
