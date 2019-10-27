package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
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


    @RequestMapping(value = "/quality/view",method = RequestMethod.POST)
    public String view(@RequestBody JSONObject json) throws IOException {

        return "";
    }


}
