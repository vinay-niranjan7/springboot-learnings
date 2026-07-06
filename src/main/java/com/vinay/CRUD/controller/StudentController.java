package com.vinay.CRUD.controller;

import java.util.List;

import com.vinay.CRUD.dto.CreateStudentRequestDto;
import com.vinay.CRUD.dto.CreateStudentResponseDto;
import com.vinay.CRUD.dto.UpdateStudentRequestDto;
import com.vinay.CRUD.dto.UpdateStudentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDto> createStudent(@RequestBody CreateStudentRequestDto student) {
        CreateStudentResponseDto createdstudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdstudent);
    }

    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@RequestParam Long id) {
        CreateStudentResponseDto studentRes = studentService.getStudent(id);
        if (studentRes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRes);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudents();
        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentList);
            }

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentRequestDto studentreq) {
        UpdateStudentResponseDto studentRes = studentService.updateStudent(id, studentreq);
        if (studentRes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRes);
            }
        
        @DeleteMapping("/delete")
        public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
            boolean isDeleted = studentService.deleteStudent(id);
            if (!isDeleted) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("deleted");
        }
        @PatchMapping("/soft-delete")
        public ResponseEntity<String> softDeleteStudent(@RequestParam Long id){
            boolean isDeleted = studentService.softDeleteStudent(id);
            if (!isDeleted) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("deleted");
        }
}
