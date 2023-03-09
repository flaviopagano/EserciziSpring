package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping(value = "/factorial")
    public Integer getFactorial() {

        int i, fact = 1;
        int number = 5;
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of "+number+" is: "+fact);
        return fact;
    }
}