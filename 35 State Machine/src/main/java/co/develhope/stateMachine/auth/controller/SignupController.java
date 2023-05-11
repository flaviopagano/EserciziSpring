package co.develhope.stateMachine.auth.controller;

import co.develhope.stateMachine.auth.entities.SignupActivationDTO;
import co.develhope.stateMachine.auth.entities.SignupDTO;
import co.develhope.stateMachine.auth.services.SignupService;
import co.develhope.stateMachine.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SignupController {

    @Autowired
    private SignupService signupService;


    @PostMapping("/signup")
    public User signup(@RequestBody SignupDTO signupDTO) throws Exception {
        return signupService.signup(signupDTO);
    }


    @PostMapping("/signup/{role}")
    public User signup(@RequestBody SignupDTO signupDTO, @PathVariable String role) throws Exception {
        return signupService.signup(signupDTO, role);
    }


    @PostMapping("/signup/activation")
    public User signup(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
        return signupService.activate(signupActivationDTO);
    }


}
