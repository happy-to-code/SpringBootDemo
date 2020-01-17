package com.example.yida.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2019/12/18
 */
@RestController
public class CookieController {

    @RequestMapping("/testCookies")
    public String cookies(HttpServletResponse response) {
        response.addCookie(new Cookie("testUser", "zhangsan"));
        return "cookies";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSession", "this is my session");
        return "testSession";
    }


    @RequestMapping("/testGetSession")
    public String testGetSession(HttpSession session) {
        Object testSession = session.getAttribute("testSession");
        return String.valueOf(testSession);
    }
}
