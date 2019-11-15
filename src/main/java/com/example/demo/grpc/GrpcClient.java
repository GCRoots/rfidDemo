package com.example.demo.grpc;

import com.example.demo.rfid.RFIDGrpc;
import com.example.demo.rfid.RFIDProto;
import com.example.demo.rfid.ReadParam;
import com.example.demo.rfid.ReadReply;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author shipengfei
 * @data 19-11-10
 */
public class GrpcClient {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8088;

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    private final ManagedChannel managedChannel;
    private final RFIDGrpc.RFIDStub rfidStub;


    public GrpcClient(String host, int port) {
        //使用明文通讯，这里简单化，实际生产环境需要通讯加密
        this(ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext()
                .build());
    }

    public GrpcClient(ManagedChannel managedChannel) {
        this.managedChannel=managedChannel;
        this.rfidStub = RFIDGrpc.newStub(managedChannel);
    }

    public void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * 实际调用部分
     * @param nums 传到服务端的数据流
     */
    public void getResult( List<Integer> nums) throws InterruptedException {

        //判断调用状态。在内部类中被访问，需要加final修饰
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        ClientResponseObserver<ReadParam, ReadReply> responseObserver =
                new ClientResponseObserver<ReadParam, ReadReply>() {

                    ClientCallStreamObserver<ReadParam> requestStream;

                    @Override
                    public void beforeStart(ClientCallStreamObserver<ReadParam> clientCallStreamObserver) {
                        this.requestStream = requestStream;
                        requestStream.disableAutoInboundFlowControl();

                        requestStream.setOnReadyHandler(new Runnable() {

                            @Override
                            public void run() {
                                // Start generating values from where we left off on a non-gRPC thread.
                                while (requestStream.isReady()) {

                                }
                            }
                        });
                    }

                    @Override
                    public void onNext(ReadReply value) {
                        logger.info("<-- " + value.toString());
                        // Signal the sender to send one message.
                        requestStream.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                        countDownLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        logger.info("All Done");
                        countDownLatch.countDown();
                    }
                };

        rfidStub.read(responseObserver);
        countDownLatch.await();

        managedChannel.shutdown();
        managedChannel.awaitTermination(1, TimeUnit.SECONDS);


    }




}
