package co.develhope.stateMachine.user.services;

import co.develhope.stateMachine.user.entities.User;
import co.develhope.stateMachine.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiderService {

    @Autowired
    private UserRepository userRepository;

    public User pickRider() {
        Optional <User> rider = userRepository.pickRider();
        if (rider.isPresent()) {
            // There is a free rider
            return rider.get();
        } else {
            // All riders are busy, take the first available
            return userRepository.findAll(PageRequest.of(0, 1)).toList().get(0);
        }
    }



}
