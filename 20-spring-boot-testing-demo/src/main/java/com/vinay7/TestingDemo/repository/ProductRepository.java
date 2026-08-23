package com.vinay7.TestingDemo.repository;

import com.vinay7.TestingDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);
}