package com.vinay7.SpringSecurityDemo.controller;


import com.vinay7.SpringSecurityDemo.dto.UserRegisterRequestDto;
import com.vinay7.SpringSecurityDemo.dto.UserRegisterResponseDto;
import com.vinay7.SpringSecurityDemo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto registerRequestDto) {
        UserRegisterResponseDto userRegisterResponseDto
                = authService.register(registerRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(
            @RequestBody UserRegisterRequestDto registerRequestDto) {
        Boolean loggedIn = authService.login(registerRequestDto);

        return ResponseEntity.ok(loggedIn);
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken) {
        return csrfToken;
    }

}