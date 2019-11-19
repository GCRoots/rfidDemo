package com.example.demo.grpc;

import com.example.demo.rfid.*;
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

    /**
     * 实际调用部分
     * @param nums 传到服务端的数据流
     */
    //init操作
    public void init( List<Integer> nums) throws InterruptedException {

        //判断调用状态。在内部类中被访问，需要加final修饰
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        ClientResponseObserver<InitParam, InitReply> responseObserver =
                new ClientResponseObserver<InitParam, InitReply>() {

                    ClientCallStreamObserver<InitParam> initCallStreamObserver;

                    @Override
                    public void beforeStart(ClientCallStreamObserver<InitParam> initCallStreamObserver) {
                        this.initCallStreamObserver = initCallStreamObserver;
                        initCallStreamObserver.disableAutoInboundFlowControl();

                        initCallStreamObserver.setOnReadyHandler(new Runnable() {

                            @Override
                            public void run() {
                                // Start generating values from where we left off on a non-gRPC thread.
                                while (initCallStreamObserver.isReady()) {

                                }
                            }
                        });
                    }

                    @Override
                    public void onNext(InitReply value) {
                        logger.info("<-- " + value.toString());

                        value.getBaseInfo().getResultCode().getNumber();

                        // Signal the sender to send one message.
                        initCallStreamObserver.request(1);
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

        rfidStub.init(responseObserver);
        countDownLatch.await();

        managedChannel.shutdown();
        managedChannel.awaitTermination(1, TimeUnit.SECONDS);

    }

    //read操作
    public void read( List<Integer> nums) throws InterruptedException {

        //判断调用状态。在内部类中被访问，需要加final修饰
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        ClientResponseObserver<ReadParam, ReadReply> responseObserver =
                new ClientResponseObserver<ReadParam, ReadReply>() {

                    ClientCallStreamObserver<ReadParam> readCallStreamObserver;

                    //client客户端连接server服务器前进行的操作
                    //eg: 将参数传递给服务器
                    @Override
                    public void beforeStart(ClientCallStreamObserver<ReadParam> readCallStreamObserver) {
                        this.readCallStreamObserver = readCallStreamObserver;
                        readCallStreamObserver.disableAutoInboundFlowControl();

                        readCallStreamObserver.setOnReadyHandler(new Runnable() {

                            @Override
                            public void run() {
                                // Start generating values from where we left off on a non-gRPC thread.
                                while (readCallStreamObserver.isReady()) {

                                }
                            }
                        });
                    }

                    //拿到一个数据后，进行相应的操作
                    @Override
                    public void onNext(ReadReply value) {
                        logger.info("<-- " + value.toString());

                        value.getBaseInfo().getResultCode().getNumber();

                        ReadParam readParam=ReadParam.newBuilder().build();
                        ReadReply readReply;

                        // Signal the sender to send one message.
                        readCallStreamObserver.request(1);
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

    //writeQualified操作 -> 质检合格时调用
    public void writeQualified( List<Integer> nums) throws InterruptedException {

        //判断调用状态。在内部类中被访问，需要加final修饰
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        ClientResponseObserver<WriteParam, WriteReply> responseObserver =
                new ClientResponseObserver<WriteParam, WriteReply>() {

                    ClientCallStreamObserver<WriteParam> writeCallStreamObserver;

                    @Override
                    public void beforeStart(ClientCallStreamObserver<WriteParam> writeCallStreamObserver) {
                        this.writeCallStreamObserver = writeCallStreamObserver;
                        writeCallStreamObserver.disableAutoInboundFlowControl();

                        writeCallStreamObserver.setOnReadyHandler(new Runnable() {

                            @Override
                            public void run() {
                                // Start generating values from where we left off on a non-gRPC thread.
                                while (writeCallStreamObserver.isReady()) {

                                }
                            }
                        });
                    }

                    @Override
                    public void onNext(WriteReply value) {
                        logger.info("<-- " + value.toString());

                        value.getBaseInfo().getResultCode().getNumber();

                        // Signal the sender to send one message.
                        writeCallStreamObserver.request(1);
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

        rfidStub.write(responseObserver);
        countDownLatch.await();

        managedChannel.shutdown();
        managedChannel.awaitTermination(1, TimeUnit.SECONDS);

    }

    //writeFailed操作 -> 质检为残次品时调用
    public void writeFailed( List<Integer> nums) throws InterruptedException {

        //判断调用状态。在内部类中被访问，需要加final修饰
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        ClientResponseObserver<WriteParam, WriteReply> responseObserver =
                new ClientResponseObserver<WriteParam, WriteReply>() {

                    ClientCallStreamObserver<WriteParam> writeCallStreamObserver;

                    @Override
                    public void beforeStart(ClientCallStreamObserver<WriteParam> writeCallStreamObserver) {
                        this.writeCallStreamObserver = writeCallStreamObserver;
                        writeCallStreamObserver.disableAutoInboundFlowControl();

                        writeCallStreamObserver.setOnReadyHandler(new Runnable() {

                            @Override
                            public void run() {
                                // Start generating values from where we left off on a non-gRPC thread.
                                while (writeCallStreamObserver.isReady()) {

                                }
                            }
                        });
                    }

                    @Override
                    public void onNext(WriteReply value) {
                        logger.info("<-- " + value.toString());

                        value.getBaseInfo().getResultCode().getNumber();

                        // Signal the sender to send one message.
                        writeCallStreamObserver.request(1);
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

        rfidStub.write(responseObserver);
        countDownLatch.await();

        managedChannel.shutdown();
        managedChannel.awaitTermination(1, TimeUnit.SECONDS);

    }

    //writeDestroy操作 -> 质检为残次品时调用
    public void writeDestroy( List<Integer> nums) throws InterruptedException {

        //判断调用状态。在内部类中被访问，需要加final修饰
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        ClientResponseObserver<WriteParam, WriteReply> responseObserver =
                new ClientResponseObserver<WriteParam, WriteReply>() {

                    ClientCallStreamObserver<WriteParam> writeCallStreamObserver;

                    @Override
                    public void beforeStart(ClientCallStreamObserver<WriteParam> writeCallStreamObserver) {
                        this.writeCallStreamObserver = writeCallStreamObserver;
                        writeCallStreamObserver.disableAutoInboundFlowControl();

                        writeCallStreamObserver.setOnReadyHandler(new Runnable() {

                            @Override
                            public void run() {
                                // Start generating values from where we left off on a non-gRPC thread.
                                while (writeCallStreamObserver.isReady()) {

                                }
                            }
                        });
                    }

                    @Override
                    public void onNext(WriteReply value) {
                        logger.info("<-- " + value.toString());

                        value.getBaseInfo().getResultCode().getNumber();

                        // Signal the sender to send one message.
                        writeCallStreamObserver.request(1);
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

        rfidStub.write(responseObserver);
        countDownLatch.await();

        managedChannel.shutdown();
        managedChannel.awaitTermination(1, TimeUnit.SECONDS);

    }




}
