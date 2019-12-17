package com.example.yida.demo.dao;

import com.example.yida.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@Mapper
public interface UserMapper {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Long id);
}
