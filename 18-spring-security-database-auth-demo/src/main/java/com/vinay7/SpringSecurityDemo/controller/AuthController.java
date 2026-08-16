package com.vinay7.SpringSecurityDemo.controller;

import com.vinay7.SpringSecurityDemo.dto.LoginRequestDto;
import com.vinay7.SpringSecurityDemo.dto.LoginResponseDto;
import com.vinay7.SpringSecurityDemo.service.jwtService;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private final ResourceLoader resourceLoader;
    private jwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, ResourceLoader resourceLoader, jwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.resourceLoader = resourceLoader;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginRequestDto loginRequestDto) {

        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                );

        Authentication authenticationResponse =
                authenticationManager.authenticate(authenticationRequest);

        String token = jwtService.generateToken(
                authenticationResponse
        );

        return new LoginResponseDto(token);


    }
}
