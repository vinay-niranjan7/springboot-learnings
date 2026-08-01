package com.vinay7.JPACascadingDemo.service;



import com.vinay7.JPACascadingDemo.model.Department;
import com.vinay7.JPACascadingDemo.model.Profile;
import com.vinay7.JPACascadingDemo.model.Student;
import com.vinay7.JPACascadingDemo.repository.DepartmentRepository;
import com.vinay7.JPACascadingDemo.repository.ProfileRepository;
import com.vinay7.JPACascadingDemo.repository.StudentJPARepository;
import com.vinay7.JPACascadingDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{
    private StudentRepository studentRepository;
    private ProfileRepository profileRepository;
    private DepartmentRepository departmentRepository;
    private StudentJPARepository studentJPARepository;

    public StudentService(StudentRepository studentRepository,
                          ProfileRepository profileRepository,
                          DepartmentRepository departmentRepository,
                          StudentJPARepository studentJPARepository) {
        this.studentRepository = studentRepository;
        this.profileRepository = profileRepository;
        this.departmentRepository = departmentRepository;
        this.studentJPARepository = studentJPARepository;
    }

    @Transactional
    public void createStudent(Student student) {
        Department department =new Department();
        department.setName("CSE");
        Profile profile = new Profile();
        profile.setBio("Java Full Stack Dev");

        student.setDepartment(department);
        student.setProfile(profile);

        profileRepository.save(profile);
        departmentRepository.save(department);
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {

        Student student = studentRepository.getStudentById(id);
        System.out.println("Lazily fetched student");

        Department department=student.getDepartment();
        System.out.println("Lazily fetched department");

        Profile profile = student.getProfile();
        System.out.println("Lazily fetched profile");

        return student;
    }
    @Transactional
    public List<Student> getAllStudents() {
        return studentJPARepository.findAll();
    }
}