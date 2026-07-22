package com.vinay7.filterdemo.controller;

import com.vinay7.filterdemo.dto.Student;
import com.vinay7.filterdemo.dto.StudentResponseDto;
import com.vinay7.filterdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody Student student) {
        StudentResponseDto responseDto =
                studentService.createStudent(student);
        return ResponseEntity.ok(responseDto);
    }
}
