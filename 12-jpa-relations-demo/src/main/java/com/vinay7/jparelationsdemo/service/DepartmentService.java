package com.vinay7.jparelationsdemo.service;

import com.vinay7.jparelationsdemo.model.Department;
import com.vinay7.jparelationsdemo.model.Student;
import com.vinay7.jparelationsdemo.repository.DepartmentRepository;
import com.vinay7.jparelationsdemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    private StudentRepository studentRepository;

    public DepartmentService(
            DepartmentRepository departmentRepository,
            StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }
    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(
            Department department,
            String studentName
    ) {
        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);

        department.getStudents().add(student);

        studentRepository.save(student);
        departmentRepository.save(department);
    }
}
