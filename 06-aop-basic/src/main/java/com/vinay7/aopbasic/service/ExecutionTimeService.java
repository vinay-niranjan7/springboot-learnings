package com.vinay7.aopbasic.service;

import com.vinay7.aopbasic.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService {

    private LoggingDecorator loggingDecorator;

    public ExecutionTimeService(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void createStudent(Student student) {
        System.out.println("ExecutionTimeService Started");
        long start = System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        long end = System.currentTimeMillis();
        System.out.println("ExecutionTimeService Finished");
        System.out.println("Execution Time: " + (end - start)  + " ms");
    }
}
