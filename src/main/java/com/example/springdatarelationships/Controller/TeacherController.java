package com.example.springdatarelationships.Controller;

import com.example.springdatarelationships.entity.Teacher;
import com.example.springdatarelationships.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping
    List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    @PostMapping
    Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepo.save(teacher);
    }

}
