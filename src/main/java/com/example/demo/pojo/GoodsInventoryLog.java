package com.example.demo.pojo;

/**
 * @author shipengfei
 * @data 19-11-6
 */
public class GoodsInventoryLog {
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
    private String goodsID;  //GOODS_ID 商品ID
    private String managerID; // MANAGER_ID 仓库管理人ID
    private String outID;     // OUTBOUND_TYPE_ID 出库类型ID
    private String outName;   // OUTBOUND_TYPE_NAME 出库名称
    private String status;    /* STATUS 商品当前状态
                               * TB_GOODS_INVENTORY_LOG 商品出入库记录表
                               * 状态(1.入库   2.出库)
                               */

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

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getOutID() {
        return outID;
    }

    public void setOutID(String outID) {
        this.outID = outID;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoodsInventoryLog{" +
                "version='" + version + '\'' +
                ", cuid='" + cuid + '\'' +
                ", cname='" + cname + '\'' +
                ", ctime='" + ctime + '\'' +
                ", uuid='" + uuid + '\'' +
                ", uname='" + uname + '\'' +
                ", utime='" + utime + '\'' +
                ", id='" + id + '\'' +
                ", factoryID='" + factoryID + '\'' +
                ", goodsID='" + goodsID + '\'' +
                ", managerID='" + managerID + '\'' +
                ", outID='" + outID + '\'' +
                ", outName='" + outName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
