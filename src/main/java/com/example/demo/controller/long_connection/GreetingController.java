package com.example.demo.controller.long_connection;

import com.example.demo.grpc.GrpcClient;
import com.example.demo.grpc.rfid_methods.GrpcReading;
import com.example.demo.rfid.ReadReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

@Controller
public class GreetingController {


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


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        int num=10;

        ArrayBlockingQueue<String> arrayBlockingQueue= new ArrayBlockingQueue<>(num);
        //生产者和消费者共用这一个队列，队列容量为num

        //Grpc客户端开始读取数据，并存放与arrayBlockingQueue中
        new GrpcReading(uuid,num,arrayBlockingQueue).start();
        //从arrayBlockingQueue中读取数据并传递给页面
        new WebSocketService(template,num,uuid,arrayBlockingQueue).start();

        return new Greeting(uuid+"\t\t" + HtmlUtils.htmlEscape(message.getName()));
    }

//    @Scheduled(fixedRate = 1000)
    public void sendServerInfo(){

        webSocketService.sendInfo();

    }


    @MessageMapping("/read")
    @SendTo("/topic/readings")
    public void reading(int num,String uuid,SimpMessagingTemplate template) throws Exception {
        Thread.sleep(1000); // simulated delay
        int readNum=0;
        
        template.convertAndSend("/topic/greetings",new HelloMessage(uuid));
        while (true){
            if (readNum>=num)
                break;
            
            
            
        }

        
        
    }


}
