package co.develhope.spingBootStart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping(value = "/name")
    public String getName() {
        return "John";
    }

    @PostMapping(value = "/reversedName")
    public String getReversedName(@RequestBody String name){
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return reversedName.toString();
    }
}