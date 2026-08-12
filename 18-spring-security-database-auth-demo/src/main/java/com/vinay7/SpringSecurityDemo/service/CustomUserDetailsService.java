package com.vinay7.SpringSecurityDemo.service;

import com.vinay7.SpringSecurityDemo.entity.CustomUserDetails;
import com.vinay7.SpringSecurityDemo.entity.User;
import com.vinay7.SpringSecurityDemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User Not found"
                ));

        return new CustomUserDetails(user);
    }
}