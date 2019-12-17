package com.example.yida.demo.common.exception;

import com.example.yida.demo.common.model.response.ResultCode;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/3
 */
public class CustomException extends RuntimeException {
    /**
     * 错误代码
     */
    ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
