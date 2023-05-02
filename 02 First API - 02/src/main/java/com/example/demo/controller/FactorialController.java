package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping(value = "/factorial/{n}")
    public Integer getFactorial(@PathVariable int n) {

        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
        }
        System.out.println("factorial=" + fact);
        return fact;
    }
}


