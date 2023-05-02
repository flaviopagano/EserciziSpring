package co.develhope.cors.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @GetMapping("/custom")
    public String getMessages(){
        return "Welcome";
    }

}