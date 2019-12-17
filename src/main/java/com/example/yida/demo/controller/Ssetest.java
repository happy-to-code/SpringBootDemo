package com.example.yida.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2019/5/23
 */
@RestController
public class Ssetest {

    @RequestMapping(value = "/abc", produces = "text/event-stream")
    @ResponseBody
    public String test() throws InterruptedException {
        Thread.sleep(1000);
        return "data: " + new Date().toLocaleString() + "\n\n";
    }
}
