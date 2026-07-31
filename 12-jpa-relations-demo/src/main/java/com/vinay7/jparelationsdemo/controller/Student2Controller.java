package com.vinay7.jparelationsdemo.controller;


import com.vinay7.jparelationsdemo.model.Course;
import com.vinay7.jparelationsdemo.model.Student2;
import com.vinay7.jparelationsdemo.service.Student2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students2")
public class Student2Controller {
    private Student2Service student2Service;

    public Student2Controller(Student2Service student2Service) {
        this.student2Service=student2Service;
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Student2 student){
        student2Service.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/{studentId}/enroll")
    public ResponseEntity<Student2> enrollStudent(
            @PathVariable Long studentId,
            @RequestParam List<Long> courseIds) {

        Student2 student = student2Service.enrollStudent(studentId, courseIds);

        return ResponseEntity.ok(student);
    }
}
