package com.zjjz.model.user;

import java.io.Serializable;
import lombok.Data;

/**
 * @author bangser
 */
@Data
public class Admin implements Serializable {
    /**
     * 管理员id
     */
    private Integer aid;

    /**
     * 用户名
     */
    private String aname;

    /**
     * 密码
     */
    private String apassword;

    /**
     * 头像id
     */
    private Integer hid;

    /**
     * 头像url
     */
    private String url;
}

