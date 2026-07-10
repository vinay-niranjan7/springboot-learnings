package com.vinay7.profiledemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiledemo")
public class DemoController {
    @Value("${app.greet.name}")
    private String name;


    @GetMapping()
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok(name);
    }
}
