package com.vinay7.hibernatedemo.service;


import com.vinay7.hibernatedemo.model.Student;
import com.vinay7.hibernatedemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        student.setPercentage(studentReq.getPercentage());
        student.setDateOfBirth(studentReq.getDateOfBirth());
        student.setStatus(studentReq.getStatus());
        student.setCurrentAddress(studentReq.getCurrentAddress());
        student.setPermanentAddress(studentReq.getPermanentAddress());
        student.setSkills(studentReq.getSkills());
        student.setProfileDescription(studentReq.getProfileDescription());
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