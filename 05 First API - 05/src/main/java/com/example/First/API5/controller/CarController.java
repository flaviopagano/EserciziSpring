package com.example.First.API5.controller;

import com.example.First.API5.DTO.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class CarController {

    @GetMapping (value = "/car")
    public  CarDTO getCar(){
        return new CarDTO("id", "Panda", 1000);
    }

    @PostMapping (value = "/createCar")
    public ResponseEntity<?> createCar(@RequestBody CarDTO car){
        System.out.println(car.toString());
        return  ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
