package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> students;

    @PostConstruct
    private void loadData() {
        this.students = new ArrayList<>();

        this.students.add(new Student("Chonsawat", "Nakanam"));
        this.students.add(new Student("Mesinee", "Yomanat"));
        this.students.add(new Student("Wanisaraporn", "Klinsawat"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return this.students.get(studentId);
    }
}
