package com.example.yida.demo.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Describle: 解析HttpServletRequest请求参数
 * @Author: zhangyifei
 * @Date: 2020/3/3
 */
public class HttpServletRequestUtil {

    /**
     * 解析body中的参数
     *
     * @param request
     * @return
     */
    public static String readAsChars(HttpServletRequest request) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
