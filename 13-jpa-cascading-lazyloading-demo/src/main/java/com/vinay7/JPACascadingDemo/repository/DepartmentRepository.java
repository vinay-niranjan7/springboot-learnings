package com.vinay7.JPACascadingDemo.repository;



import com.vinay7.JPACascadingDemo.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department findById(Long deptId) {
        return entityManager.find(Department.class,deptId);
    }


    public void removeDepartment(Department department) {
        entityManager.remove(department);
    }
}
