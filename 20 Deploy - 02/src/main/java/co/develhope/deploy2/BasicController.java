package co.develhope.deploy2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sum")
public class BasicController {

    int a = 1;
    int b = 2;

    @GetMapping
    public int getSum(){
        return a+b;
    }

}