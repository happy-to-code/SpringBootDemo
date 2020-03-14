package com.example.yida.demo.util;

import lombok.Data;

import java.util.List;

/**
 * @Describle:客户详情的follow——user信息
 * @Author: zhangyifei
 * @Date: 2020/3/11 14:29
 */
@Data
public class FollowUserBO {

    /**
     * userid
     */
    private String userid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long createtime;

    /**
     * 标签
     */
    private List<TagBO> tags;

    /**
     * 公司名
     */
    private String remark_corp_name;

    /**
     * 状态
     */
    private String state;

    /**
     * 手机号
     */
    private List<String> remark_mobiles;

}
