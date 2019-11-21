package com.zjjz.api.ucenter;

import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.model.user.Headportrait;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 17:10
 **/
@Api(value = "头像信息获取",tags = {"头像信息获取"})
public interface HeadPortraitController {

    /**
     * 获取所有头像信息
     * @return
     */
    @ApiOperation("获取所有头像信息")
    QueryResponseResult<Headportrait> findAllHeadPortrait();

    /**
     * 根据id获取头像信息
     * @param hid
     * @return
     */
    @ApiOperation("根据id获取头像信息")
    QueryResponseResult<Headportrait> findHeadPortraitByHid(Integer hid);
}
