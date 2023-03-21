package co.develhope.interceptorsmiddleware1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegacyController {

    @GetMapping(value = "/legacy")
    public void getLegacy(){
        System.out.println("This is just old code");
    }
}
