package com.example.demo.controller.long_connection.read;

import java.util.Map;

/**
 * @author shipengfei
 * @data 19-12-5
 */
public class Reading {
    //当前已扫描riid类型及其对应的标签数
    private Map<String,Integer> clothesNum;
    //当前已扫描riid标签数，即实入库数
    private int num;

    public Reading() {
    }

    public Reading(Map<String, Integer> clothesNum, int num) {
        this.clothesNum = clothesNum;
        this.num = num;
    }

    public Map<String, Integer> getClothesNum() {
        return clothesNum;
    }

    public int getNum() {
        return num;
    }
}
