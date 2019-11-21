package com.zjjz.model.user;

import java.io.Serializable;
import lombok.Data;

/**
 * @author bangser
 */
@Data
public class Headportrait implements Serializable {
    /**
     * 头像id
     */
    private Integer hid;

    /**
     * 头像地址
     */
    private String url;

}

