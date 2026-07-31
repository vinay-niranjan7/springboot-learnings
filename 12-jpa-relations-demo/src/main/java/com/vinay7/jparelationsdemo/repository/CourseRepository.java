package com.vinay7.jparelationsdemo.repository;

import com.vinay7.jparelationsdemo.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Course course) {
        entityManager.persist(course);
    }
}
