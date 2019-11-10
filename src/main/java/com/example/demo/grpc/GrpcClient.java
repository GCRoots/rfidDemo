package com.example.demo.grpc;

import com.example.demo.rfid.RFIDGrpc;
import io.grpc.ManagedChannel;

import java.util.logging.Logger;

/**
 * @author shipengfei
 * @data 19-11-10
 */
public class GrpcClient {
    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    private final ManagedChannel channel;
    private final RFIDGrpc.RFIDStub Stub;


    public GrpcClient(ManagedChannel channel, RFIDGrpc.RFIDStub stub) {
        this.channel = channel;
        Stub = stub;
    }
}
