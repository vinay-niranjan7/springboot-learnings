package com.vinay7.JPACascadingDemo.repository;



import com.vinay7.JPACascadingDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student getStudentById(Long id) {
        return entityManager.find(Student.class,id);
    }
}