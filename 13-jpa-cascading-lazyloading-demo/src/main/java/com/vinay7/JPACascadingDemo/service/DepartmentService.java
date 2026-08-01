package com.vinay7.JPACascadingDemo.service;


import com.vinay7.JPACascadingDemo.model.Department;
import com.vinay7.JPACascadingDemo.model.Student;
import com.vinay7.JPACascadingDemo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Transactional
    public void createDepartment(Department department) {
        Student s1= new Student();
        s1.setName("Vinu");
        s1.setDepartment(department);

        Student s2= new Student();
        s2.setName("Vinayyyy");
        s2.setDepartment(department);
        department.getStudents().addAll(List.of(s1,s2));
        departmentRepository.save(department);
    }

    @Transactional
    public void removeDepartment(Long deptId) {
        Department department = departmentRepository.findById(deptId);
        departmentRepository.removeDepartment(department);
    }
}
