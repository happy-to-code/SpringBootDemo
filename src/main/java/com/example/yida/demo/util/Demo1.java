package com.example.yida.demo.util;

import java.util.Arrays;
import java.util.List;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/3/17 11:26
 */
public class Demo1 {
    public static void main(String[] args) {
        // String ss = "11";
        // ss.to

        List<String> list = Arrays.asList("11", "22", "33");

        for (String s : list) {
            try {
                if (s.equals("22")) {
                    System.out.println(s.substring(-1, 100));
                }
                System.out.println("s = " + s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
