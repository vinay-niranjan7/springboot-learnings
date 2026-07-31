package com.vinay7.jparelationsdemo.service;

import com.vinay7.jparelationsdemo.model.Profile;
import com.vinay7.jparelationsdemo.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile addProfile(Profile profile,Long userId) {
        return profileRepository.save(profile,userId);
    }


}