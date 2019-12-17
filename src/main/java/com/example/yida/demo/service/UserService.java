package com.example.yida.demo.service;

import com.example.yida.demo.common.model.response.CommonCode;
import com.example.yida.demo.common.model.response.QueryResponseResult;
import com.example.yida.demo.common.model.response.QueryResult;
import com.example.yida.demo.common.model.response.ResponseResult;
import com.example.yida.demo.dao.UserRepository;
import com.example.yida.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @Transactional
    public ResponseResult saveUser(User user) {
        User save = userRepository.save(user);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    public QueryResult<User> findAll() {
        List<User> users = userRepository.findAll();

        QueryResult<User> queryResult = new QueryResult<>();
        queryResult.setList(users);
        queryResult.setTotal(users.size());

        return queryResult;
    }
}
