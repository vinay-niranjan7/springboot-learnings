package com.vinay7.LoggingDemo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger log =
            LogManager.getLogger(HelloService.class);

    public static String greet() {
        log.info("greet() method started");

        String message="Welcome to Logging Demo";

        log.info("Returning message: {}", message);
        return message;
    }
}
