package com.zjjz.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 17:02
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginResult<T> extends ResponseResult{

    private T auser; //管理员或用户对象

    public LoginResult(ResultCode resultCode, T auser) {
        super(resultCode);
        this.auser = auser;
    }
}
