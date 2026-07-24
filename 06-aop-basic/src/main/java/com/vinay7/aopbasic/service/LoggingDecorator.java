package com.vinay7.aopbasic.service;


import com.vinay7.aopbasic.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {

    private StudentServiceImpl studentServiceimpl;

    public LoggingDecorator(StudentServiceImpl studentServiceimpl) {
        this.studentServiceimpl = studentServiceimpl;
    }

    @Override
    public void createStudent(Student student) {


        LoggingServiceUtil.logStart(
                "StudentServiceImpl", "createStudent");
        System.out.println("LoggingDecorator Started");

        studentServiceimpl.createStudent(student);

        System.out.println("LoggingDecorator Finished");

        LoggingServiceUtil.logEnd(
                "StudentServiceImpl", "createStudent");
    }
}
