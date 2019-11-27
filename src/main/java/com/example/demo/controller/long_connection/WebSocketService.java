package com.example.demo.controller.long_connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shipengfei
 * @data 19-11-27
 */
@Component
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendInfo(){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        template.convertAndSend("/topic/greetings",new HelloMessage(now.format(df)));

    }
}
