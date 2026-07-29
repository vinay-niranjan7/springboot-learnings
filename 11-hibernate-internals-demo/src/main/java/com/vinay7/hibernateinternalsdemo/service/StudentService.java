package com.vinay7.hibernateinternalsdemo.service;

import com.vinay7.hibernateinternalsdemo.model.Student;
import com.vinay7.hibernateinternalsdemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }


    @Transactional
    public void updateStudent(Student studentReq, Long id) {
        Student student = studentRepository.findById(id);

        if(student == null) {
            throw new RuntimeException("Student not found");
        }

        //studentRepository.detach(student1);
        //student1 = studentRepository.attachAgain(student1);

        student.setName(studentReq.getName());
        studentRepository.flush();

        student.setAge(studentReq.getAge());
        studentRepository.flush();

        student.setEmail(studentReq.getEmail());
        studentRepository.flush();
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);

        if(student == null) {
            throw new RuntimeException("Student not found");
        }

        studentRepository.remove(student);
    }
}
