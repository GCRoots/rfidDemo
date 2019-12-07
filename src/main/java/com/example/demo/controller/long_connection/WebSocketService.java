package com.example.demo.controller.long_connection;

import com.example.demo.controller.long_connection.hello_demo.Greeting;
import com.example.demo.controller.long_connection.hello_demo.HelloMessage;
import com.example.demo.controller.long_connection.read.Reading;
import com.example.demo.pojo.GoodsInfo;
import com.example.demo.server.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author shipengfei
 * @data 19-11-27
 */
@Component
public class WebSocketService extends Thread{

    @Autowired
    private SimpMessagingTemplate template;

    private int num;
    private String[] attributes;
    private String uuid;
    private ArrayBlockingQueue<String> arrayBlockingQueue;

    @Autowired
    private GoodsInfoServer goodsInfoServer;

    public WebSocketService(){
    }

    public WebSocketService(SimpMessagingTemplate template,int num,String[] attributes,String uuid,ArrayBlockingQueue<String> arrayBlockingQueue){
        this.template=template;
        this.num=num;
        this.attributes=attributes;
        this.uuid=uuid;
        this.arrayBlockingQueue=arrayBlockingQueue;
    }

    public WebSocketService(SimpMessagingTemplate template,int num,String uuid,ArrayBlockingQueue<String> arrayBlockingQueue){
        this.template=template;
        this.num=num;
        this.uuid=uuid;
        this.arrayBlockingQueue=arrayBlockingQueue;
    }





    public void reading() throws Exception {
        Thread.sleep(1000); // simulated delay

        Map<String,Integer> map=new HashMap<>();

        for (String attribute:attributes)
            map.put(attribute,0);

        //已读RFID数量
        int real=0;

        while (true){
            if (num==real)
                break;

            String rfid = arrayBlockingQueue.poll(1, TimeUnit.SECONDS);
            //从队列拿到已读的RFID
            //如果queue为null，那么5秒之后再去队列中取数据
            if (rfid!=null){
                //根据RFID数据库拿到对应数据
                GoodsInfo goodsInfo=goodsInfoServer.FindByInfoRFID(rfid);

                String attrs=goodsInfo.getFourAttributes();

                if(map.containsKey(attrs)){
                    int n=map.get(attrs);
                    map.put(attrs,n+1);
                    real++;
                }else{

                }

            }

            template.convertAndSend("/topic/greetings",new Greeting(uuid+"-"+num));
            template.convertAndSend("/topic/greetings",new Reading(map,real));
        }

    }

    public void run(){
        try {
            reading();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void sendInfo(){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        template.convertAndSend("/topic/greetings",new HelloMessage(now.format(df)));

    }
}
