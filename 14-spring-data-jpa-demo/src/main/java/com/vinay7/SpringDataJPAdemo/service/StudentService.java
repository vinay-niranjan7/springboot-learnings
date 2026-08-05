package com.vinay7.SpringDataJPAdemo.service;

import com.vinay7.SpringDataJPAdemo.entity.Student;
import com.vinay7.SpringDataJPAdemo.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    // Get Student By ID
    public Student fetchStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Student not found with id : " + id));
    }

    // Get Students By Name
     public List<Student> fetchStudentsByName(String name) {

            Pageable pageable = PageRequest.of(0, 5);

            return studentRepository
                    .findByNameContainingIgnoreCase(name, pageable)
                    .getContent();
        }

    public Student fetchStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));
    }

    // Sorting + Pagination
    public List<Student> fetchStudentsWithSorting() {

        Pageable pageable = PageRequest.of(
                0,
                5,
                Sort.by("name").ascending()
                        .and(Sort.by("age").descending())
        );

        Page<Student> students = studentRepository.findAll(pageable);

        return students.getContent();
    }

    // Update Student
    public Student updateStudent(Long id, Student studentReq) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Student not found with id : " + id));

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());

        return studentRepository.save(student);
    }
}