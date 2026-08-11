package com.vinay7.SpringSecurityDemo.repository;


import com.vinay7.SpringSecurityDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}