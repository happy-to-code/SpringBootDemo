package com.example.yida.demo.common.exception;

import com.example.yida.demo.common.model.response.ResultCode;

/**
 * @Describle:
 * @Author:zhangyifei
 * @Date:2019/1/3
 */
public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
