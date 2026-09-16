package com.vinay7.LoggingDemo.controller;

import com.vinay7.LoggingDemo.service.HelloService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloService helloService;
    private Logger log= LogManager.getLogger(HelloController.class);

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/greet")
    private ResponseEntity<String> greet(){

        log.info("greet() method started");

        String message = helloService.greet();

        log.info("Message received from service: {}", message);
        log.info("greet() method completed");
        return ResponseEntity.ok(message);
    }
}
