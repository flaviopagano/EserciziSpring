package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @GetMapping(value = "/strings")
    public ResponseEntity <?> getStrings(@RequestParam (name = "nome1") String nome1,
                                     @RequestParam (name = "nome2") String nome2)
    {
        try {
            String ret;

            if (nome2 != null && nome2.isBlank()){
                 ret = nome1 + " " + nome2;
            }
            else {
                ret = nome1;
            }
            return ResponseEntity.ok(ret);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
