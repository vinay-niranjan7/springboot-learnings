package com.vinay7.jparelationsdemo.repository;
import com.vinay7.jparelationsdemo.model.Profile;
import com.vinay7.jparelationsdemo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Profile save(Profile profile, Long userId) {

        User user = entityManager.find(User.class, userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        profile.setUser(user);
        user.setProfile(profile);

        entityManager.persist(profile);
        return profile;
    }

    public Profile getById(Long id) {
        return entityManager.find(Profile.class, id);
    }
}