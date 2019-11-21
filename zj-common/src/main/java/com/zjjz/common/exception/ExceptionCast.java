package com.zjjz.common.exception;


import com.zjjz.common.model.ResultCode;

/**
 * @Description 抛出异常的工具类
 * @author BangSer
 * @date 2019/7/26 19:55
 */
public class ExceptionCast {

    /**
     * 抛出方法
     * @param resultCode
     */
    public static void throwCustomException(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
