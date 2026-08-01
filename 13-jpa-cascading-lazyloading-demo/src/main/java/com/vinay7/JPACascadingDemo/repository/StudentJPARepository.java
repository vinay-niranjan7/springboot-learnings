package com.vinay7.JPACascadingDemo.repository;



import com.vinay7.JPACascadingDemo.model.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJPARepository extends JpaRepository<Student, Long> {

    @Override
    @EntityGraph(attributePaths = "department")
    List<Student> findAll();
}