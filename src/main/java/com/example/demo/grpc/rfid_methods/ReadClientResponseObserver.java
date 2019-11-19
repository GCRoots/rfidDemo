package com.example.demo.grpc.rfid_methods;

import com.example.demo.rfid.ReadParam;
import com.example.demo.rfid.ReadReply;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;

/**
 * @author shipengfei
 * @data 19-11-16
 */
public class ReadClientResponseObserver implements ClientResponseObserver<ReadParam, ReadReply> {


    @Override
    public void beforeStart(ClientCallStreamObserver<ReadParam> clientCallStreamObserver) {

    }

    @Override
    public void onNext(ReadReply readReply) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }
}
