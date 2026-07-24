package com.vinay7.aopbasic.repository;

import com.vinay7.aopbasic.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student saved");

    }
}
