package com.vinay7.SpringSecurityBasicsDemo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.web.csrf.CsrfToken;

@RestController
@RequestMapping("/api/test")
public class SecurityTestController {

    @GetMapping
    public String getTest(){
        return "getTest Method Executed";
    }

    @PostMapping
    public String postTest(){
        return "postTest Method Executed";
    }

    @PutMapping
    public String updateTest(){
        return "updateTestMethod Executed";
    }

    @DeleteMapping
    public String deleteTest(){
        return "deleteTest Method Executed";
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }

}
