package co.develhope.interceptorsmiddleware1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping
public class BasicController {

    @GetMapping(value = "/time")
    public void getTime(){
        LocalDateTime lt = LocalDateTime.now();
        System.out.println(lt);
    }
}
