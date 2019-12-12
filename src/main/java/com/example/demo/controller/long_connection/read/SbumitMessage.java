package com.example.demo.controller.long_connection.read;

/**
 * 接收前台消息的消息体
 *
 * @author shipengfei
 * @data 19-12-12
 */
public class SbumitMessage {
    //此次写入的RFID簇对应的tag（uuid）
    private int uuid;
    //将要提交的RFID标签类型   eg:类型/款号/色号/尺码
    private String[] fourAttributes;

    public SbumitMessage() {
    }

    public SbumitMessage(int uuid, String[] fourAttributes) {
        this.uuid = uuid;
        this.fourAttributes = fourAttributes;
    }

    public int getUuid() {
        return uuid;
    }

    public String[] getFourAttributes() {
        return fourAttributes;
    }
}
