package com.vinay7.jparelationsdemo.repository;

import com.vinay7.jparelationsdemo.model.Course;
import com.vinay7.jparelationsdemo.model.Student2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Student2Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student2 student) {
        entityManager.persist(student);
    }

    public Student2 enrollStudent(Long studentId, List<Long> courseIds) {

        Student2 student = entityManager.find(Student2.class, studentId);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        for (Long courseId : courseIds) {
            Course course = entityManager.find(Course.class, courseId);
            if (course == null) {
                throw new RuntimeException("Course not found: " + courseId);
            }
            student.getCourses().add(course);
            course.getStudents().add(student);
        }
        entityManager.merge(student);
        return student;
    }
}
