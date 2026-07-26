package com.vinay7.aopdemo.service;

import com.vinay7.aopdemo.annotation.TrackExecutionTime;
import com.vinay7.aopdemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime
    public Student createStudent(Student student) {
        try {
            Thread.sleep(1000);
        }
        catch(Exception e) {}
        System.out.println("Student saved");
        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1750,
            operation = "get students"
    )
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}

        System.out.println(s);
        return s;
    }

    public int dummyMethod() {
        return 0;
    }

}
