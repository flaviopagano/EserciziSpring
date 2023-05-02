package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @GetMapping(value = "/strings")
    public String getStrings(@RequestParam String a, @RequestParam (required = false) String b) {

        if (b == null) {
            return a;
        }
        return a + " " + b;

        }
    }
