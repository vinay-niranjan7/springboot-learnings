package com.vinay7.jparelationsdemo.service;



import com.vinay7.jparelationsdemo.model.Profile;
import com.vinay7.jparelationsdemo.model.User;
import com.vinay7.jparelationsdemo.repository.ProfileRepository;
import com.vinay7.jparelationsdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserService(UserRepository userRepository,ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository=profileRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @Transactional
    public User addUser(User user,Long profileId) {
        Profile profile=profileRepository.getById(profileId);
        user.setProfile(profile);
        profile.setUser(user);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }
}