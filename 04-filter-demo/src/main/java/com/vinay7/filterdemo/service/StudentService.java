package com.vinay7.filterdemo.service;

import com.vinay7.filterdemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student) {
        System.out.println("ID: "+student.getId());
        System.out.println("Name: "+student.getName());
        System.out.println("Student Created");
    }
}