package com.example.yida.demo.common.model.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@Data
@ToString
public class QueryResult<T> {
    /**
     * 数据列表
     */
    private List<T> list;
    /**
     * 数据总数
     */
    private long total;
}
