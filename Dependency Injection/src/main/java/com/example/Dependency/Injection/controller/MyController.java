package com.example.Dependency.Injection.controller;

import com.example.Dependency.Injection.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {
    private MyService myService;

    public MyController(MyService myService) {
        System.out.println("MyComponent constructor has been called");
        this.myService = myService;
    }

    @GetMapping
    public String helloMsg(){
        return "Hello, thanks for visiting us!";
    }


    @GetMapping("/getName")
    public String getName() {
        System.out.println("MyController.index() has been called");
        return myService.getName();

    }
}
