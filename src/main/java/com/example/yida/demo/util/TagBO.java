package com.example.yida.demo.util;

import lombok.Data;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/3/11 14:37
 */
@Data
public class TagBO {
    /**
     * 标签分组名称
     */
    private String group_name;

    /**
     * 标签名称
     */
    private String tag_name;

    /**
     * type
     */
    private Integer type;


}
