package com.kraemer.primeira_api_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot REST API";
    }
}
