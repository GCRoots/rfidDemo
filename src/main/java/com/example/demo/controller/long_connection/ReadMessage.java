package com.example.demo.controller.long_connection;

import java.util.Map;

/**
 * @author shipengfei
 * @data 19-12-3
 */
public class ReadMessage {
    private int num;
    private String type;
    private String style;
    private String color;
    private String size;
    private String[] fourAttributes;
    private Map<String,Integer> clothesNum;

    public ReadMessage() {
    }

    public ReadMessage(int num, String type, String style, String color, String size, String[] fourAttributes, Map<String, Integer> clothesNum) {
        this.num = num;
        this.type = type;
        this.style = style;
        this.color = color;
        this.size = size;
        this.fourAttributes = fourAttributes;
        this.clothesNum = clothesNum;
    }

    public int getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String[] getFourAttributes() {
        return fourAttributes;
    }

    public Map<String, Integer> getClothesNum() {
        return clothesNum;
    }
}
