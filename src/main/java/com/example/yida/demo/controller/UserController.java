package com.example.yida.demo.controller;

import com.example.yida.demo.common.model.response.QueryResult;
import com.example.yida.demo.common.model.response.ResponseResult;
import com.example.yida.demo.netty.demo1.MyWebSocketHandler;
import com.example.yida.demo.netty.demo3.WebsocketServerHandler;
import com.example.yida.demo.pojo.User;
import com.example.yida.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @PutMapping("save")
    public ResponseResult saveUser(@RequestParam("mapper") User user) {
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
