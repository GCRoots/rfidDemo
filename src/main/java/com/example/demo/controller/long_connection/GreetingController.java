package com.example.demo.controller.long_connection;

import com.example.demo.grpc.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import javax.websocket.Session;
import java.util.UUID;

@Controller
public class GreetingController {

    private String uuid;

    @Autowired
    private WebSocketService webSocketService;

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8088;

    private static final GrpcClient client=new GrpcClient(DEFAULT_HOST,DEFAULT_PORT);

    /**
     * websochet消息发送对象
     */
    @Autowired
    private SimpMessagingTemplate template;

    private Session session;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        uuid = UUID.randomUUID().toString().replaceAll("-", "");

        for (int i=0;i<10;i++){

            template.convertAndSend("/topic/greetings",new HelloMessage(uuid));

        }
        return new Greeting(uuid+"\t\t" + HtmlUtils.htmlEscape(message.getName()));
    }

//    @Scheduled(fixedRate = 1000)
    public void sendServerInfo(){

        webSocketService.sendInfo();

    }


    @MessageMapping("/read")
    @SendTo("/topic/readings")
    public Greeting reading() throws Exception {
        Thread.sleep(1000); // simulated delay

//        client.read();

        return new Greeting(uuid);
    }


}
