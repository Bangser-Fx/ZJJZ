package com.zjjz.common.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class QueryResponseResult<T> extends ResponseResult {

    //数据集
    QueryResult<T> queryResult;


    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
