package co.develhope.deploy1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class BasicController {

    @GetMapping("/name")
    public String getName(){
        return "Flavio";
    }


}