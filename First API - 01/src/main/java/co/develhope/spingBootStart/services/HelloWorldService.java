package co.develhope.spingBootStart.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String sayHelloWorld(){
        return "Hello World";
    }
}
