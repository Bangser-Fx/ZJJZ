package com.zjjz.model.product;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author bangser
 */
@Data
public class ProductBace implements Serializable {
    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品名
     */
    private String pname;

    /**
     * 商品描述
     */
    private String pdetial;

    /**
     * 库存
     */
    private Long pnumber;

    /**
     * 图片(多个图片用,分开)
     */
    private String pictures;

    /**
     * 价格
     */
    private Double price;

    /**
     * 发布时间
     */
    private String beginTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 商品一级分类id
     */
    private Integer cidone;

    /**
     * 商品二级分类id
     */
    private Integer cidtwo;


}

