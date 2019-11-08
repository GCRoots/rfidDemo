package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.mapper.GoodsColorMapper;
import com.example.demo.pojo.Data;
import com.example.demo.pojo.GoodsColor;
import com.example.demo.server.GoodsColorServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author shipengfei
 * @data 19-10-27
 */

@RestController
public class Quality {

    @Autowired
    private GoodsColorServer goodsColorServer;

    @RequestMapping(value = "/quality/qualified",method = RequestMethod.POST)
    public String qualified(@RequestBody JSONObject json) throws IOException {

        Data d= JSON.parseObject(json.toString(), Data.class);
        String id=d.getId();

        GoodsColor color=goodsColorServer.FindByColorID(id);
        System.out.println(color.toString());

        String s=JSON.toJSONString(color);
        return s;
    }


}
