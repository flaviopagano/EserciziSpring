package co.develhope.spingBootStart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/name")
    public String getName() {
        return "John";
    }

    @PostMapping("/reversedName")
    public String getReversedName(){
        String name = "John";
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return reversedName.toString();
    }

    /**
     * questi metodi di GetMapping e
     * PostMapping li ho trovati su chatGPT
     */



}
