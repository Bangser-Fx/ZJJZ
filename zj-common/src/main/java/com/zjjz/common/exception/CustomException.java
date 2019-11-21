package com.zjjz.common.exception;


import com.zjjz.common.model.ResultCode;

/**
 * @Description 自定义异常类
 * @author BangSer
 * @date 2019/7/26 19:51
 */
public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
