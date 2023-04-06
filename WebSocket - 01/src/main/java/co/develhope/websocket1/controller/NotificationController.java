package co.develhope.websocket1.controller;

import co.develhope.websocket1.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/broadcast-message")
    public ResponseEntity sendNotification(@RequestBody MessageDTO message){
        simpMessagingTemplate.convertAndSend("/topic/broadcast", message);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Questa funzione permette di usare la casella in alto a destra nel browser 'your name here'
     */

   /* @MessageMapping("/hello")
    @SendTo("/topic/broadcast")
    public MessageDTO messageFromSocket(MessageDTO message){
        System.out.println("Message received " + message.toString());

        return new MessageDTO("From " + message.getType() + " - Text " + message.getMessage());
    } */

}