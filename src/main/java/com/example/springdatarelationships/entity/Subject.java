package com.example.springdatarelationships.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents=new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher=teacher;
    }
}
