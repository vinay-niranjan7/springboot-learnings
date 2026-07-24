package com.vinay7.aopbasic.service;


import com.vinay7.aopbasic.dto.Student;
import com.vinay7.aopbasic.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
//        try {
//            Thread.sleep(1000);
//        }
//        catch(Exception e) {}

        studentRepository.save(student);
        System.out.println("StudentServiceImpl Executed");
    }
}
