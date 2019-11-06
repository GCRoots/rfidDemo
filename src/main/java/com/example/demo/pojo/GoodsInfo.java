package com.example.demo.pojo;

/**
 * @author shipengfei
 * @data 19-11-6
 */
public class GoodsInfo {
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
    private String RFID;      // RFID 对应RFID
    private String typeID;    // TYPE_ID 商品类型ID
    private String typeName;  // TYPE_NAME 商品类型名称
    private String styleID;   // STYLE_ID 商品款号ID
    private String styleName; // STYLE_NAME 商品款号名称
    private String colorID;   // COLOR_ID 商品色号ID
    private String colorName; // COLOR_NAME 商品色号名称
    private String sizeID;    // SIZE_ID 商品尺码ID
    private String sizeName;  // SIZE_NAME 商品尺码名称
    private String status;    /* STATUS 商品当前状态
                               * TB_GOODS_INFO 商品信息表
                               * 状态(1.待质检 2.返修 3.销毁 4.合格 5.入库 6.出库)
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

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStyleID() {
        return styleID;
    }

    public void setStyleID(String styleID) {
        this.styleID = styleID;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getColorID() {
        return colorID;
    }

    public void setColorID(String colorID) {
        this.colorID = colorID;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeID() {
        return sizeID;
    }

    public void setSizeID(String sizeID) {
        this.sizeID = sizeID;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "version='" + version + '\'' +
                ", cuid='" + cuid + '\'' +
                ", cname='" + cname + '\'' +
                ", ctime='" + ctime + '\'' +
                ", uuid='" + uuid + '\'' +
                ", uname='" + uname + '\'' +
                ", utime='" + utime + '\'' +
                ", id='" + id + '\'' +
                ", factoryID='" + factoryID + '\'' +
                ", RFID='" + RFID + '\'' +
                ", typeID='" + typeID + '\'' +
                ", typeName='" + typeName + '\'' +
                ", styleID='" + styleID + '\'' +
                ", styleName='" + styleName + '\'' +
                ", colorID='" + colorID + '\'' +
                ", colorName='" + colorName + '\'' +
                ", sizeID='" + sizeID + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
