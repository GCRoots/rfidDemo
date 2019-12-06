package com.example.demo.pojo.Grpc;

import java.util.List;

/**
 * @author shipengfei
 * @data 19-12-6
 */
public class TempRead {
    private String uuid;
    private int num;
    private List<String> rfids;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<String> getRfids() {
        return rfids;
    }

    public void setRfids(List<String> rfids) {
        this.rfids = rfids;
    }

    @Override
    public String toString() {
        return "TempRead{" +
                "uuid='" + uuid + '\'' +
                ", num=" + num +
                ", rfids=" + rfids +
                '}';
    }
}
