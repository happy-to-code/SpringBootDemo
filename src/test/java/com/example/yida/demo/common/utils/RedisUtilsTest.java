package com.example.yida.demo.common.utils;

import com.alibaba.fastjson.JSON;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisUtilsTest {
    @Resource
    RedisUtils redisUtils;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    public void keys() {
        //存储数据
        stringRedisTemplate.boundValueOps("age").set("12", 60, TimeUnit.SECONDS);

        //获取数据
        String string = stringRedisTemplate.opsForValue().get("name");
        System.out.println(string);
    }

}