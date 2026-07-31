package com.vinay7.jparelationsdemo.service;

import com.vinay7.jparelationsdemo.model.Student2;
import com.vinay7.jparelationsdemo.repository.Student2Repository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student2Service {
    private Student2Repository student2Repository;

    public Student2Service(Student2Repository student2Repository) {
        this.student2Repository = student2Repository;
    }

    @Transactional
    public void createStudent(Student2 student) {
        student2Repository.save(student);
    }

    @Transactional
    public Student2 enrollStudent(Long studentId, List<Long> courseIds) {
        return student2Repository.enrollStudent(studentId, courseIds);
    }
}
