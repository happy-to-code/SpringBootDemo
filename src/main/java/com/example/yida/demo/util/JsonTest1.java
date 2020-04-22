package com.example.yida.demo.util;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/3/18 21:54
 */
public class JsonTest1 {
    public static void main(String[] args) {
        // JSONObject jsonObject = new JSONObject();
        // jsonObject.put("name", "zhangsan");
        // jsonObject.put("age", 11L);
        // // jsonObject.put("sex", "女");
        //
        // System.out.println(jsonObject);
        // System.out.println(jsonObject.toJSONString());
        // System.out.println("====================");
        // User121 user121 = JSONObject.parseObject(jsonObject.toJSONString(), User121.class);
        // System.out.println("user121 = " + user121);


        List<JSONObject> list = new ArrayList<>(10);

        JSONObject jsonObject = new JSONObject();
        // 数据库字段
        List<String> fields = Arrays.asList("id", "sex", "age");
        jsonObject.put("fields", fields);

        List<Object> dataList = new ArrayList<>(10);
        User121 user1 = new User121("zz", "男", 17L);
        User121 user2 = new User121("xx", "女", 18L);
        dataList.add(user1);
        dataList.add(user2);
        jsonObject.put("data", dataList);

        list.add(jsonObject);

        System.out.println(list);


    }
}

@Data
@ToString
@AllArgsConstructor
class User121 {
    /**
     * name
     */
    private String name;

    /**
     * sex
     */
    private String sex;

    /**
     * age
     */
    private Long age;


}
