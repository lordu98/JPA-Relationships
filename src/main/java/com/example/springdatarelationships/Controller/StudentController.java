package com.example.springdatarelationships.Controller;

import com.example.springdatarelationships.entity.Student;
import com.example.springdatarelationships.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping
    List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

}
