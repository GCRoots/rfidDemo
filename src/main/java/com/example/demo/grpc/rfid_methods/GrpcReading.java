package com.example.demo.grpc.rfid_methods;

import com.example.demo.grpc.GrpcClient;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author shipengfei
 * @data 19-12-2
 */
public class GrpcReading extends Thread{
    private String uuid;
    private int num;
    private ArrayBlockingQueue<String> arrayBlockingQueue;

    public GrpcReading(){
    }

    public GrpcReading(String uuid, int num, ArrayBlockingQueue<String> arrayBlockingQueue) {
        this.uuid = uuid;
        this.num = num;
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    public void reading() throws Exception {
        Thread.sleep(1000); // simulated delay

        GrpcClient grpcClient=new GrpcClient("localhost",8888);
        grpcClient.read(num,uuid,arrayBlockingQueue);

    }

    public void run(){
        try {
            reading();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
