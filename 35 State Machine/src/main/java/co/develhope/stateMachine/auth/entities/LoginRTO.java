package co.develhope.stateMachine.auth.entities;

import co.develhope.stateMachine.user.entities.User;
import lombok.Data;

@Data
public class LoginRTO {

    private User user;
    private String JWT;
}
