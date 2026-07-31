package com.vinay7.jparelationsdemo.controller;


import com.vinay7.jparelationsdemo.model.Department;
import com.vinay7.jparelationsdemo.model.Student;
import com.vinay7.jparelationsdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController{
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam Long deptId){
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/withdept")
    public ResponseEntity<String> createStudent(@RequestBody Student student,@RequestParam String deptName){
        studentService.createStudent(student,deptName);
        return ResponseEntity.ok("DONE");
    }
}