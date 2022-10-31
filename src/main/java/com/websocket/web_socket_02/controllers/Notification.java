package com.websocket.web_socket_02.controllers;

import com.websocket.web_socket_02.DTO.ClientMessageDTO;
import com.websocket.web_socket_02.DTO.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Notification {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/broadcast-message")
    public ResponseEntity sendNotificationToClients(@RequestBody MessageDTO message) {
        simpMessagingTemplate.convertAndSend("/broadcast/messages", message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @MessageMapping("/client-message")
    @SendTo("/topic/broadcast")
    public MessageDTO handleMessageFromWebSocket(ClientMessageDTO message){
        System.out.println("Client message: " + message.toString());
        return new MessageDTO("Message from " + message.getClientName() + " - " + message.getClientMsg());
    }
}
