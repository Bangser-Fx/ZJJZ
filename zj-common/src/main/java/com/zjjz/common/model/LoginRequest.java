package com.zjjz.common.model;

import lombok.Data;
import lombok.ToString;

/**
 * Created by admin on 2018/3/5.
 */
@Data
@ToString
public class LoginRequest extends RequestData {

    String username;//用户名
    String password;//密码
    String verifycode;//？验证码

}
