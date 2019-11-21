package com.zjjz.api.product;

import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.QueryResult;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 14:26
 **/
@Api(value = "商品分类管理",tags = {"商品分类管理"})
public interface CategoryController {

    /**
     * 添加商品分类
     * @param category
     * @return
     */
    @ApiOperation("添加分类")
    ResponseResult addCategory(Category category);

    /**
     * 根据id获取分类信息
     * @param cid
     * @return
     */
    @ApiOperation("根据id获取分类信息")
    QueryResponseResult<Category> getCategoryById(Integer cid);

    /**
     * 修改商品分类
     * @param category
     * @return
     */
    @ApiOperation("修改分类")
    ResponseResult updateCategory(Category category);

    /**
     * 删除商品分类
     * @param cid
     * @return
     */
    @ApiOperation("删除分类")
    ResponseResult deleteCategory(Integer cid);

    /**
     * 查找一级分类
     * @return
     */
    @ApiOperation("查找一级分类")
    QueryResponseResult<Category> findOneCategory();

    /**
     * 查找二级分类
     * @return
     */
    @ApiOperation("查找二级分类")
    QueryResponseResult<Category> findTwoCategory();
}
