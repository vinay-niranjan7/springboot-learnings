package com.vinay7.aopdemo.service;

import com.vinay7.aopdemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student) {
        System.out.println("Student saved");
        //throw new RuntimeException("Some error happened"); // to check logAfterThrowingMethod() & logAroundMethod()
        return student;
    }

    public String dummyMethod(String s) {
        System.out.println("dummyMethod called");
        return s;
    }
}
