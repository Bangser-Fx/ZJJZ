package com.zjjz.product.controller;

import com.zjjz.api.product.ProductController;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.Product;
import com.zjjz.model.product.ProductBace;
import com.zjjz.model.product.ProductCondition;
import com.zjjz.model.product.ProductMarket;
import com.zjjz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 15:33
 **/
@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    @Override
    public ResponseResult addProduct(@RequestBody ProductBace productBace) {
        return productService.addProduct(productBace);
    }

    @PostMapping("/update/productBace")
    @Override
    public ResponseResult updateProductBace(@RequestBody ProductBace productBace) {
        return productService.updateProductBace(productBace);
    }

    @PostMapping("/update/productMarket")
    @Override
    public ResponseResult updateProductMarket(@RequestBody ProductMarket productMarket) {
        return productService.updateProductMarket(productMarket);
    }

    @GetMapping("/delete/product/{pid}")
    @Override
    public ResponseResult deleteProduct(@PathVariable("pid") Integer pid) {
        return productService.deleteProduct(pid);
    }

    @GetMapping("/delete/productMarket/{id}")
    @Override
    public ResponseResult deleteProductMarket(@PathVariable("id") Integer id) {
        return productService.deleteProductMarket(id);
    }

    @PostMapping("/find/productList/{page}/{size}")
    @Override
    public QueryResponseResult<ProductBace> findProductPageByCondition(@PathVariable("page") Integer page,
                                                                       @PathVariable("size") Integer size,
                                                                       @RequestBody(required = false) ProductCondition condition) {
        return productService.findProductPageByCondition(page,size,condition);
    }

    @GetMapping("/find/product/{pid}")
    @Override
    public QueryResponseResult<Product> findProductById(@PathVariable("pid") Integer pid) {
        return productService.findProductById(pid);
    }
}
