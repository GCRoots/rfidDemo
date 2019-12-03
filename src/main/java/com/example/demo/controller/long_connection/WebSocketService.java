package com.example.demo.controller.long_connection;

import com.example.demo.pojo.GoodsInfo;
import com.example.demo.server.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private String uuid;
    private int num;
    private ArrayBlockingQueue<String> arrayBlockingQueue;

    @Autowired
    private GoodsInfoServer goodsInfoServer;

    public WebSocketService(){
    }

    public WebSocketService(SimpMessagingTemplate template,int num,String uuid,ArrayBlockingQueue<String> arrayBlockingQueue){
        this.template=template;
        this.num=num;
        this.uuid=uuid;
        this.arrayBlockingQueue=arrayBlockingQueue;
    }



    public void reading() throws Exception {
        Thread.sleep(1000); // simulated delay


        while (true){
            if (num<=0)
                break;
            String rfid = arrayBlockingQueue.poll(5, TimeUnit.SECONDS);
            //如果queue为null，那么5秒之后再去队列中取数据
            if (rfid!=null){
                GoodsInfo goodsInfo=goodsInfoServer.FindByInfoRFID(rfid);
                goodsInfo.getSizeName();
                goodsInfo.getColorName();
                goodsInfo.getTypeName();
                goodsInfo.getStyleName();
                String basic=goodsInfo.getFourAttributes();

            }

            template.convertAndSend("/topic/greetings",new HelloMessage(uuid+"-"+num));
            num--;
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
