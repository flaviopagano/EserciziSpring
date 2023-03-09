package com.example.Swagger1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to my API!";
    }
}
