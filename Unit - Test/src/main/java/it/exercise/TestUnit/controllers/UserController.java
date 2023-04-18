package it.exercise.TestUnit.controllers;

import it.exercise.TestUnit.entities.User;
import it.exercise.TestUnit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userRepository.findAll();

        return ResponseEntity.ok(users);

    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            return ResponseEntity.ok(user);

        } else {

            return ResponseEntity.notFound().build();

        }

    }


    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(savedUser);

    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            user.setFirstName(updatedUser.getFirstName());

            user.setLastName(updatedUser.getLastName());

            user.setEmail(updatedUser.getEmail());

            User savedUser = userRepository.save(user);

            return ResponseEntity.ok(savedUser);

        } else {

            return ResponseEntity.notFound().build();

        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            userRepository.delete(optionalUser.get());

            return ResponseEntity.ok().build();

        } else {

            return ResponseEntity.notFound().build();

        }

    }

}
