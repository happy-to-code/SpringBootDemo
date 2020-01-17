package com.example.yida.demo.util;

import java.util.Date;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2019/12/19
 */
public class DateTest {
    public static void main(String[] args) {
        String date = DateUtils.getDate(new Date(), -730);
        System.out.println(date);
    }
}
