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
public class WebSocketService extends Thread{

    @Autowired
    private SimpMessagingTemplate template;

    private String uuid="";
    private int num=0;

    public WebSocketService(){
    }

    public WebSocketService(SimpMessagingTemplate template,int num,String uuid){
        this.template=template;
        this.num=num;
        this.uuid=uuid;
    }

    public void sendInfo(){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        template.convertAndSend("/topic/greetings",new HelloMessage(now.format(df)));

    }

    public void reading(int num,String uuid,SimpMessagingTemplate template) throws Exception {
        Thread.sleep(1000); // simulated delay
        int readNum=0;

        while (true){
            if (readNum>=num)
                break;

            template.convertAndSend("/topic/greetings",new HelloMessage(uuid+"-"+readNum));
            readNum++;
        }

    }

    public void run(){
        try {
            reading(num,uuid,template);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
