package com.example.yida.demo.common.model.response;

import lombok.Data;
import lombok.ToString;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/2
 */
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {
    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }
}
