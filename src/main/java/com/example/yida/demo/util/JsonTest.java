package com.example.yida.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/1/17
 */
public class JsonTest {
    public static void main(String[] args) {
        String str = "[{\"createtime\":1576676937,\"remark_mobiles\":[\"13915549857\",\"f4a97290a049007e47d4\"],\"description\":\"三的放松放松费\",\"remark\":\"胡斌1\",\"state\":\"123456\",\"userid\":\"liuqian_bs\",\"tags\":[]},{\"createtime\":1577314779,\"remark_mobiles\":[\"v75027b1e93dca82bf85\"],\"description\":\"\",\"remark\":\"\",\"state\":\"PresaleTask\",\"userid\":\"Shaliuxin\",\"tags\":[]},{\"createtime\":1583225184,\"remark_mobiles\":[\"123456\"],\"description\":\"\",\"remark\":\"#62937#胡先生\",\"state\":\"123456\",\"userid\":\"wenchengyi\",\"tags\":[]}]";
        System.out.println("str = " + str);

        // FollowUserBO followUserBO = JSONObject.parseObject(JSON.toJSONString(str), FollowUserBO.class);
        // System.out.println("followUserBO = " + followUserBO);


        // 解析follow_user数据JSON.parseArray(jsonString2, User.class);
        List<FollowUserBO> followUserBOList = JSON.parseArray(JSON.toJSONString(JSON.parse(str)), FollowUserBO.class);
        System.out.println("followUserBOList = " + followUserBOList);
        // List<FollowUserBO> followUserBOList1 = JSON.parseArray(JSON.toJSONString(str), FollowUserBO.class);
        // System.out.println("followUserBOList1 = " + followUserBOList1);


        // String s = "{'name': 'zhangsan', 'sex': 'man'}";
        //
        // System.out.println(s);
        //
        // Map map = JSONObject.parseObject(s, Map.class);
        //
        // System.out.println(map);
    }
}
