package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController{

    @GetMapping(value = "/math")
    public String welcomeToMathMsg(){
        return "Welcome to the Math API";
    }

    @GetMapping(value = "/math/division/{a}/{b}")
    public int getDivisionInfo(@PathVariable int a, @PathVariable int b){
        return a / b;
    }


    @GetMapping(value = "/math/multiplication/{a}/{b}")
    public int getMultiplication(@PathVariable int a, @PathVariable int b){
        return a * b;
    }

    @GetMapping("/math/square/{n}")
    public int getSquare(@PathVariable int n) {
        return n * n;


    }
}