package com.example.yida.demo.dao;

import com.example.yida.demo.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据登录名查询
     *
     * @param loginName
     * @return
     */
    List<User> findByLoginName(String loginName);

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable);

}
