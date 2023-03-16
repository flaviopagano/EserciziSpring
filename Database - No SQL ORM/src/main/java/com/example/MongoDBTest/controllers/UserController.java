package com.example.MongoDBTest.controllers;

import com.example.MongoDBTest.entities.User;
import com.example.MongoDBTest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUsers(@PathVariable String id){
        return userRepository.findById(id);
    }
}
