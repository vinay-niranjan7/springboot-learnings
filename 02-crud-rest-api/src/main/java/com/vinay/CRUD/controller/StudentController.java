package com.vinay.CRUD.controller;

import java.util.List;

import com.vinay.CRUD.dto.CreateStudentRequestDto;
import com.vinay.CRUD.dto.CreateStudentResponseDto;
import com.vinay.CRUD.dto.UpdateStudentRequestDto;
import com.vinay.CRUD.dto.UpdateStudentResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vinay.CRUD.entity.Student;
import com.vinay.CRUD.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid @RequestBody CreateStudentRequestDto student) {
        CreateStudentResponseDto createdstudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdstudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id) {
        CreateStudentResponseDto studentRes = studentService.getStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentRes);
    }
    
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
            }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentRequestDto studentreq) {
        UpdateStudentResponseDto studentRes = studentService.updateStudent(id, studentreq);
        return ResponseEntity.status(HttpStatus.OK).body(studentRes);
    }
        
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> softDeleteStudent(@RequestParam Long id){
        studentService.softDeleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
}
