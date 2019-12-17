package com.example.yida.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@Data
@NoArgsConstructor
@ToString
@Entity
public class User {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;
}
