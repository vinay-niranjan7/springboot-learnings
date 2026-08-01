package com.vinay7.JPACascadingDemo.controller;


import com.vinay7.JPACascadingDemo.model.Student;
import com.vinay7.JPACascadingDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController{
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){

        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}