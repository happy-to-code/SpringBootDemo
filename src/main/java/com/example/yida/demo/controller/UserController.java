package com.example.yida.demo.controller;

import com.example.yida.demo.common.model.response.QueryResult;
import com.example.yida.demo.common.model.response.ResponseResult;
import com.example.yida.demo.common.utils.HttpServletRequestUtil;
import com.example.yida.demo.netty.demo1.MyWebSocketHandler;
import com.example.yida.demo.netty.demo3.WebsocketServerHandler;
import com.example.yida.demo.pojo.User;
import com.example.yida.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    MyWebSocketHandler myWebSocketHandler;

    @Autowired
    private WebsocketServerHandler websocketServerHandler;

    @Autowired
    private Environment env;

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("save")
    public ResponseResult saveUser(@RequestBody User user) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        String s = HttpServletRequestUtil.readAsChars(request);
        System.out.println(s);
        ResponseResult responseResult = userService.saveUser(user);
        return responseResult;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("findAllUser")
    public QueryResult<User> findAll() throws IOException {
        myWebSocketHandler.sendAllMessage("______AAAAA______");
        System.out.println(env.getProperty("wework.chat.callBackCorpID1"));
        System.out.println(env.getProperty("wework.chat.callBackToken1"));
        System.out.println(env.getProperty("wework.chat.callBackEncodingAESKey1"));
        return userService.findAll();
    }

    /**
     * 根据ID查询用户
     *
     * @return
     */
    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
