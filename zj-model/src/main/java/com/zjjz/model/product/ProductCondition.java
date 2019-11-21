package com.zjjz.model.product;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品查询条件
 * @author bangser
 * @version 1.0
 * @date 2019-10-29 21:46
 **/
@Data
public class ProductCondition implements Serializable {


    /**
     * 商品名
     */
    private String pname;

    /**
     * 商品描述
     */
    private String pdetial;

    /**
     * 商品一级分类
     */
    private Integer cidone;

    /**
     * 商品二级分类
     */
    private Integer cidtwo;

    /**
     * 最低价
     */
    private Double minPrice;

    /**
     * 最高价
     */
    private Double maxPrice;
}
