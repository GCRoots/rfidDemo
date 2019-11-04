package com.example.demo.pojo;

/**
 * @author shipengfei
 * @data 19-10-25
 */
public class Data {

    //BASIC ATTRIBUTE
    private String version; // _VERSION 版本号,用于锁
    private String cuid;    // _CREATE_USER_ID 创建用户ID
    private String cname;   // _CREATE_USER_NAME 创建用户名
    private String ctime;   // _CREATE_TIME 创建时间
    private String uuid;    // _UPDATE_USER_ID 更新用户ID
    private String uname;   // _UPDATE_USER_NAME 更新用户名
    private String utime;   // _UPDATE_TIME 更新时间

    private String id; // ID
    private String name; // NAME 名称(款式、类型、色号、尺码)
    private String code; // CODE 代码(类型、色号、尺码)
    private String factoryID; // FACTORY_ID 工厂ID
    private String goodsTypeID; // GOODS_TYPE_ID 所属商品类型ID
    private String goodsStyleID; // GOOD_STYLE_ID 所属款号ID
    private String goodsColorID; // GOODS_COLOR_ID 所属色号ID

}
