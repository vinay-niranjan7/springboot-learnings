package com.vinay7.jparelationsdemo.controller;

import com.vinay7.jparelationsdemo.model.Profile;
import com.vinay7.jparelationsdemo.service.ProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @PostMapping
    public Profile addProfile(@RequestBody Profile profile, @RequestParam Long userId) {
        return profileService.addProfile(profile,userId);
    }


}