package com.zjjz.product.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjjz.common.exception.ExceptionCast;
import com.zjjz.common.model.CommonCode;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.QueryResult;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.common.utils.TimeUtil;
import com.zjjz.model.product.Product;
import com.zjjz.model.product.ProductBace;
import com.zjjz.model.product.ProductCondition;
import com.zjjz.model.product.ProductMarket;
import com.zjjz.product.mapper.ProductMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 15:34
 **/
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 添加商品信息
     *
     * @param productBace
     * @return
     */
    @Transactional
    public ResponseResult addProduct(ProductBace productBace) {
        if (productBace == null || productBace.getCidone() == null || productBace.getCidtwo() == null || productBace.getPrice() == null
                || StringUtils.isBlank(productBace.getPdetial()) || StringUtils.isBlank(productBace.getPname()) || StringUtils.isBlank(productBace.getPictures())) {
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        productBace.setPid(null);
        productBace.setBeginTime(TimeUtil.getNow());
        productBace.setUpdateTime(TimeUtil.getNow());
        Integer i = productMapper.addProductBace(productBace);
        if (i != 1) {
            ExceptionCast.throwCustomException(CommonCode.FAIL);
        }
//        if (productMarkets.size() > 0) {
//            for (ProductMarket productMarket : productMarkets) {
//                if (productMarket != null && StringUtils.isNotBlank(productMarket.getDescription()) && StringUtils.isNotBlank(productMarket.getType()) && StringUtils.isNotBlank(productMarket.getPicture())) {
//                    productMarket.setId(null);
//                    productMarket.setPid(productBace.getPid());
//                    productMapper.addProduceMarket(productMarket);
//                }
//            }
//        }
        return ResponseResult.SUCCESS();
    }

    /**
     * 修改商品基本信息
     *
     * @param productBace
     * @return
     */
    @Transactional
    public ResponseResult updateProductBace(ProductBace productBace) {
        if (productBace == null || productBace.getPid() == null || productBace.getCidone() == null || productBace.getCidtwo() == null || productBace.getPrice() == null
                || StringUtils.isBlank(productBace.getPdetial()) || StringUtils.isBlank(productBace.getPname()) || StringUtils.isBlank(productBace.getPictures())) {
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        productMapper.updateProductById(productBace);
        return ResponseResult.SUCCESS();
    }

    /**
     * 修改商品营销信息
     *
     * @param productMarket
     * @return
     */
    @Transactional
    public ResponseResult updateProductMarket(ProductMarket productMarket) {
        if (productMarket.getId() == null || productMarket.getPid() == null || StringUtils.isBlank(productMarket.getDescription()) || StringUtils.isBlank(productMarket.getType()) || StringUtils.isBlank(productMarket.getPicture())) {
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        productMapper.updateProductMarketById(productMarket);
        return ResponseResult.SUCCESS();
    }

    /**
     * 删除商品
     *
     * @param pid
     * @return
     */
    @Transactional
    public ResponseResult deleteProduct(Integer pid) {
        productMapper.deleteProductById(pid);
        productMapper.deleteProductMarketByPid(pid);
        return ResponseResult.SUCCESS();
    }

    /**
     * 删除商品营销信息
     *
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult deleteProductMarket(Integer id) {
        productMapper.deleteProductMarketById(id);
        return ResponseResult.SUCCESS();
    }

    /**
     * 根据条件分页查询商品列表
     *
     * @param page
     * @param size
     * @param condition
     * @return
     */
    public QueryResponseResult<ProductBace> findProductPageByCondition(Integer page, Integer size, ProductCondition condition) {
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        if (condition == null) {
            condition = new ProductCondition();
        }
        PageHelper.startPage(page, size);
        Page<ProductBace> productBacePage = productMapper.findProductBaceByCondition(condition);
        QueryResult<ProductBace> result = new QueryResult<>();
        result.setTotal(productBacePage.getTotal());
        result.setList(productBacePage.getResult());
        result.setPage(page);
        result.setSize(size);
        return new QueryResponseResult<>(CommonCode.SUCCESS, result);
    }

    /**
     * 查询商品信息
     *
     * @param pid
     * @return
     */
    public QueryResponseResult<Product> findProductById(Integer pid) {
        if (pid == null) {
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        //查询商品基本信息
        ProductBace productBace = productMapper.findProductById(pid);
        if (productBace == null) {
            ExceptionCast.throwCustomException(CommonCode.SERVER_ERROR);
        }
        //查询商品营销信息
        List<ProductMarket> productMarkets = productMapper.findProductMarketByPid(pid);
        List<HashMap<String, ProductMarket>> list = new ArrayList<>();
        if (productMarkets != null && productMarkets.size() > 0) {
            for (ProductMarket productMarket : productMarkets) {
                HashMap<String, ProductMarket> hashMap = new HashMap<>();
                hashMap.put(productMarket.getDescription(), productMarket);
                list.add(hashMap);
            }
        }
        //封装数据
        Product product = new Product(list);
        BeanUtils.copyProperties(productBace,product);
        QueryResult<Product> result  = new QueryResult<>();
        result.setTotal(1);
        result.setObj(product);
        return new QueryResponseResult<>(CommonCode.SUCCESS,result);
    }
}
