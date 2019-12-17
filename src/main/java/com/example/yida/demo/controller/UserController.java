package com.example.yida.demo.controller;

import com.example.yida.demo.common.model.response.QueryResult;
import com.example.yida.demo.common.model.response.ResponseResult;
import com.example.yida.demo.pojo.User;
import com.example.yida.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 保存用户信息
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
     * @return
     */
    @GetMapping("findAllUser")
    public QueryResult<User> findAll(){
        return userService.findAll();
    }
}
