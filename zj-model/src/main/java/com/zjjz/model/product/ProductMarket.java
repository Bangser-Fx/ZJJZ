package com.zjjz.model.product;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品营销信息
 * @author bangser
 */
@Data
@EqualsAndHashCode
public class ProductMarket implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品类型
     */
    private String type;

    /**
     * 类型描述
     */
    private String description;

    /**
     * 对应图片
     */
    private String picture;

}

