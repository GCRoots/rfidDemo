package com.example.demo.controller.long_connection;

import com.example.demo.grpc.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.UUID;

@Controller
public class GreetingController {

    private String uuid;

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8088;

    private static final GrpcClient client=new GrpcClient(DEFAULT_HOST,DEFAULT_PORT);

    /**
     * websochet消息发送对象
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        uuid = UUID.randomUUID().toString().replaceAll("-", "");

        return new Greeting(uuid+"    Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/read")
    @SendTo("/topic/readings")
    public Greeting reading() throws Exception {
        Thread.sleep(1000); // simulated delay

//        client.read();

        return new Greeting(uuid);
    }


}
