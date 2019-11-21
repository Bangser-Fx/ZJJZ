package com.zjjz.api.product;

import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.Product;
import com.zjjz.model.product.ProductBace;
import com.zjjz.model.product.ProductCondition;
import com.zjjz.model.product.ProductMarket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 15:16
 **/
@Api(value = "商品管理",tags = {"商品管理"})
public interface ProductController {

    /**
     * 添加商品
     * @param productBace
     * @return
     */
    @ApiOperation("添加商品")
    ResponseResult addProduct(ProductBace productBace);

    /**
     * 修改商品基本信息
     * @return
     */
    @ApiOperation("更新商品基本信息")
    ResponseResult updateProductBace(ProductBace productBace);

    /**
     * 修改商品营销信息
     * @param productMarket
     * @return
     */
    @ApiOperation("更新商品营销信息")
    ResponseResult updateProductMarket(ProductMarket productMarket);

    /**
     * 删除商品
     * @param pid
     * @return
     */
    @ApiOperation("删除商品")
    ResponseResult deleteProduct(Integer pid);

    /**
     * 删除商品营销信息
     * @param id
     * @return
     */
    @ApiOperation("删除商品营销信息")
    ResponseResult deleteProductMarket(Integer id);

    /**
     * 根据条件分页查询商品信息（基本信息）
     * @param page
     * @param size
     * @param condition
     * @return
     */
    @ApiOperation("分页查询商品列表")
    QueryResponseResult<ProductBace> findProductPageByCondition(Integer page,Integer size,ProductCondition condition);

    /**
     * 根据id查询商品详细信息
     * @param pid
     * @return
     */
    @ApiOperation("查询商品全部信息")
    QueryResponseResult<Product> findProductById(Integer pid);
}
