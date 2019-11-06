package com.example.demo.pojo;

/**
 * @author shipengfei
 * @data 19-11-6
 */
public class TailorInfo {
    //BASIC ATTRIBUTE
    private String version; // _VERSION 版本号,用于锁
    private String cuid;    // _CREATE_USER_ID 创建用户ID
    private String cname;   // _CREATE_USER_NAME 创建用户名
    private String ctime;   // _CREATE_TIME 创建时间
    private String uuid;    // _UPDATE_USER_ID 更新用户ID
    private String uname;   // _UPDATE_USER_NAME 更新用户名
    private String utime;   // _UPDATE_TIME 更新时间

    private String id;           // ID
    private String factoryID;    // FACTORY_ID 工厂ID

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(String factoryID) {
        this.factoryID = factoryID;
    }

    @Override
    public String toString() {
        return "TailorInfo{" +
                "version='" + version + '\'' +
                ", cuid='" + cuid + '\'' +
                ", cname='" + cname + '\'' +
                ", ctime='" + ctime + '\'' +
                ", uuid='" + uuid + '\'' +
                ", uname='" + uname + '\'' +
                ", utime='" + utime + '\'' +
                ", id='" + id + '\'' +
                ", factoryID='" + factoryID + '\'' +
                '}';
    }
}
