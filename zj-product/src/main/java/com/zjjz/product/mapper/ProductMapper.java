package com.zjjz.product.mapper;

import com.github.pagehelper.Page;
import com.zjjz.model.product.Product;
import com.zjjz.model.product.ProductBace;
import com.zjjz.model.product.ProductCondition;
import com.zjjz.model.product.ProductMarket;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-29 21:14
 **/
@Mapper
public interface ProductMapper {

    /**
     * 添加商品基本信息
     * @param productBace
     * @return
     */
    int addProductBace(ProductBace productBace);

    /**
     * 添加商品营销信息
     * @param productMarket
     * @return
     */
    int addProduceMarket(ProductMarket productMarket);

    /**
     * 根据id查询商品
     * @param pid
     * @return
     */
    ProductBace findProductById(Integer pid);

    /**
     * 根据条件查询商品
     * @param condition
     * @return
     */
    Page<ProductBace> findProductBaceByCondition(ProductCondition condition);

    /**
     * 根据商品id查询商品营销信息
     * @param pid
     * @return
     */
    List<ProductMarket> findProductMarketByPid(Integer pid);

    /**
     * 根据id删除商品基本信息
     * @param pid
     * @return
     */
    int deleteProductById(Integer pid);

    /**
     * 根据商品id删除商品营销信息
     * @param pid
     * @return
     */
    int deleteProductMarketByPid(Integer pid);

    /**
     * 根据id删除商品营销信息
     * @param id
     * @return
     */
    int deleteProductMarketById(Integer id);

    /**
     * 更新商品基本信息
     * @param productBace
     */
    void updateProductById(ProductBace productBace);

    /**
     * 更新商品营销信息
     * @param productMarket
     */
    void updateProductMarketById(ProductMarket productMarket);
}
