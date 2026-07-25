package com.vinay7.aopdemo.controller;


import com.vinay7.aopdemo.dto.Student;
import com.vinay7.aopdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod() {
        String s = "Vinay";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
