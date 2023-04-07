package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    Environment environment;
    @Autowired
    BasicService basicService;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String welcome(){
        logger.info("start log");
        return "Welcome";
    }


    @GetMapping("/exp")
    public double getExponent(){
        return basicService.getExponent();
    }

    @GetMapping("/get-errors")
    public void error() throws Exception {
        Error error = new Error("This is the custom error");
        logger.error("This is the error log", error);
    }



}