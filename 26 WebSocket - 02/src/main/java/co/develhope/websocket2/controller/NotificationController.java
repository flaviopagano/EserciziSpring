package co.develhope.websocket2.controller;

import co.develhope.websocket2.entities.ClientMessageDTO;
import co.develhope.websocket2.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/broadcast-message")
    @SendTo("/topic/broadcast")
    public MessageDTO broadcastMessage(MessageDTO message) {
        System.out.println(message.toString());
        return new MessageDTO();
    }

    // Molto importante l'ordine dei Message, altrimenti sono alla rinfusa
    @MessageMapping("/client-message")
    @SendTo("/topic/broadcast")
    public MessageDTO clientMessage(ClientMessageDTO message) {
        System.out.println(message.toString());
        return new MessageDTO(
                message.getClientName(),
                message.getClientAlert(),
                message.getClientMsg()
        );
    }


}