package com.forze.sale.controller;

import com.forze.sale.config.Message;
import com.forze.sale.config.OutputMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@RestController
@Controller
public class SimpleController {
    @Autowired
    private SimpMessagingTemplate stompClient;
    @GetMapping("/send")
    public OutputMessage test(){
        OutputMessage msg = new OutputMessage("test", "test", "1111");
        this.stompClient.convertAndSend("/topic/messages", msg);
        return msg;
    }
}