package com.example.yida.demo.controller;

import com.example.yida.demo.common.model.response.QueryResult;
import com.example.yida.demo.common.utils.BCryptUtil;
import com.example.yida.demo.dao.UserMapper;
import com.example.yida.demo.dao.UserRepository;
import com.example.yida.demo.pojo.User;
import com.example.yida.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    @Resource
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Resource
    UserMapper userMapper;

    @Test
    public void testMyBatisFindById(){
        User user = userMapper.findById(3L);
        System.out.println(user);
    }


    @Test
    public void testPageQuery(){
        int page = 1, size = 3;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> all = userRepository.findAll(pageable);
        System.out.println(all);
        // userRepository.findByUserName("testName", pageable);
    }

    @Test
    public void findById() {
        Optional<User> optionalUser = userRepository.findById(3L);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user);
        }
    }


    @Test
    public void findByLoginName() {
        List<User> users = userRepository.findByLoginName("damimi");
        System.out.println(users);
    }

    @Test
    public void saveUser() {
        User user = new User();
        // mapper.setId(5L);
        user.setUserName("dami1166");
        user.setLoginName("damimi12");
        user.setPassWord(BCryptUtil.encode("22222266"));

        userService.saveUser(user);

    }

    @Test
    public void findAll() {
        QueryResult<User> all = userService.findAll();
        List<User> list = all.getList();
        System.out.println(list);
    }

    @Test
    public void testBCrypt() {
        boolean a = BCryptUtil.matches("111111", "$2a$10$HnvTNjNGvEA08JhM1MQpVeOe5pfdhn3iMkSQ4LcgJKex7fwbNhhMC");
        boolean b = BCryptUtil.matches("111111", "$2a$10$9rs5TQNtNjoS22zPFViHXeO264DvKh.RWLezj8gpI0loLrBO7m4km");
        boolean c = BCryptUtil.matches("111111", "$2a$10$nfL1mE1gVwl3rwCC7q/AzuESuzEuTaijlokyRZhboh/OIaFezs0F6");

        System.out.println("======================");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("======================");
    }
}