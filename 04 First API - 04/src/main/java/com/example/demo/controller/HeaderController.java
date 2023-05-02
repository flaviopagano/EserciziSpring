package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeaderController {

    @GetMapping(value = "/getHeaders")
     public String getServerName(HttpServletRequest request) {
        return request.getServerName() + ", "+ request.getServerPort();
    }




}
