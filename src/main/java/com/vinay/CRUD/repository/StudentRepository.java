package com.vinay.CRUD.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vinay.CRUD.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

    
}
