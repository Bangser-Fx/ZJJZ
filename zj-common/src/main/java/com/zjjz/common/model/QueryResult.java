package com.zjjz.common.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */
@Data
@ToString
public class QueryResult<T> {

    //数据列表
    private List<T> list;
    //数据总数
    private long total;
    //单个数据
    private T obj;
    //页数
    private Integer page;
    //单页条数
    private Integer size;
}
