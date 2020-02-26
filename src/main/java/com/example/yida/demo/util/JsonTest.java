package com.example.yida.demo.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/1/17
 */
public class JsonTest {
    public static void main(String[] args) {
        String s = "{'name': 'zhangsan', 'sex': 'man'}";

        System.out.println(s);

        Map map = JSONObject.parseObject(s, Map.class);

        System.out.println(map);
    }
}
