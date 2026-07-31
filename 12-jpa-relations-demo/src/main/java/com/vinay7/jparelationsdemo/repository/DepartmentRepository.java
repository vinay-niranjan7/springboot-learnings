package com.vinay7.jparelationsdemo.repository;

import com.vinay7.jparelationsdemo.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department getDepartmentById(long deptId) {
        return entityManager.find(Department.class,deptId);
    }
}
