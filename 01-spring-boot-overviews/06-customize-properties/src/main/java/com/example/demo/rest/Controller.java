package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${jwt.secret}")
    private String jwt_secret;

    @GetMapping("/")
    public String home() {
        return jwt_secret + " " + System.getenv("JWT_SECRET");
    }

}
