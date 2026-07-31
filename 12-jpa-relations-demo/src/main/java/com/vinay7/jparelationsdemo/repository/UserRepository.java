package com.vinay7.jparelationsdemo.repository;


import com.vinay7.jparelationsdemo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}