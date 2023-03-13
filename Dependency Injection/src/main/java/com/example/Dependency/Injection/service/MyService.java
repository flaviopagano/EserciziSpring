package com.example.Dependency.Injection.service;

import com.example.Dependency.Injection.component.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private MyComponent myComponent;


    @Autowired
    public MyService(MyComponent myComponent) {
        System.out.println("MyService constructor has been called");
        this.myComponent = myComponent;
    }


    public String getName() {
        System.out.println("MyService.getName() has been called");
        return myComponent.getMyComponentName();
    }

    /**
     * l'errore mi dice che devo usare un bean ma quando lo aggiungo,
     * dà un altro errore
     */
}
