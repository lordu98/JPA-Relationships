package com.example.springdatarelationships.Controller;

import com.example.springdatarelationships.entity.Student;
import com.example.springdatarelationships.entity.Subject;
import com.example.springdatarelationships.entity.Teacher;
import com.example.springdatarelationships.repo.StudentRepo;
import com.example.springdatarelationships.repo.SubjectRepo;
import com.example.springdatarelationships.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    SubjectRepo subjectRepo;
    StudentRepo studentRepo;
    TeacherRepo teacherRepo;

    @Autowired
    public SubjectController(SubjectRepo subjectRepo, StudentRepo studentRepo, TeacherRepo teacherRepo) {
        this.subjectRepo = subjectRepo;
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
    }

    @GetMapping
    List<Subject> getSubjects() {
        return subjectRepo.findAll();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectRepo.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(@PathVariable Integer subjectId,
                                   @PathVariable Integer studentId) {

        Subject subject = subjectRepo.findById(subjectId).get();
        Student student = studentRepo.findById(studentId).get();
        subject.enrollStudent(student);

        return subjectRepo.save(subject);
    }

    @PutMapping("/{subjectId}/teachers/{teacherId}")
    Subject assignTeacherToSubject(@PathVariable Integer subjectId,
                                   @PathVariable Integer teacherId) {

        Subject subject = subjectRepo.findById(subjectId).get();
        Teacher teacher = teacherRepo.findById(teacherId).get();
        subject.assignTeacher(teacher);

        return subjectRepo.save(subject);
    }

}
