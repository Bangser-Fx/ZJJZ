package com.zjjz.model.product;

import java.io.Serializable;
import lombok.Data;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-29 20:57
 **/
@Data
public class Category implements Serializable {
    private Integer cid;

    private String cname;

    private Integer level;

    private static final long serialVersionUID = 1L;
}