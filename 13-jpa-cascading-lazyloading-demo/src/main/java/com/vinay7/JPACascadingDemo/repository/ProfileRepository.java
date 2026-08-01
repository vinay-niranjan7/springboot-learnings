package com.vinay7.JPACascadingDemo.repository;

import com.vinay7.JPACascadingDemo.model.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class ProfileRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Profile profile) {
        entityManager.persist(profile);
    }
}