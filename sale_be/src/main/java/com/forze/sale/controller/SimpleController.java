package com.forze.sale.controller;

import com.forze.sale.config.OutputMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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