package com.zjjz.common.model;


import lombok.ToString;

/**
 * @author bangser
 */
@ToString
public enum CommonCode implements ResultCode{

    INVALIDPARAM(false,10001,"非法参数！"),
    SUCCESS(true,10002,"操作成功！"),
    FAIL(false,10003,"操作失败！"),
    UNAUTHENTICATED(false,10004,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10005,"权限不足，无权操作！"),
    UNALLOWFILE(false,10006,"非图片文件！"),
    LOGINFAIL(false,10007,"用户名或密码错误！"),
    LOGINSUCCESS(true,10008,"登录成功！"),
    IDOVERTIME(false,10009,"登录身份过期！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
