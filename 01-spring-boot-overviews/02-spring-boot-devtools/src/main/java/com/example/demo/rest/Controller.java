package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String home() {
        return "<h1>Chonsawat Nakanam</h1>";
    }

    @GetMapping("/users")
    public String users() {
        return "This is Users right";
    }

}
