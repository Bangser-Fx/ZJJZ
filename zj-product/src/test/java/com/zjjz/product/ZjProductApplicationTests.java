package com.zjjz.product;


import com.alibaba.fastjson.JSON;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.utils.TimeUtil;
import com.zjjz.model.product.Category;
import com.zjjz.model.product.Product;
import com.zjjz.model.product.ProductBace;
import com.zjjz.product.mapper.CategoryMapper;
import com.zjjz.product.mapper.ProductMapper;
import com.zjjz.product.service.CategoryService;
import com.zjjz.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZjProductApplicationTests {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void contextLoads() {
        QueryResponseResult<Product> product = productService.findProductById(1001);
        System.out.println(product);
        String s = JSON.toJSONString(product);
        System.out.println(s);
    }

    @Test
    public void test2() {
        int i = productMapper.deleteProductById(1);
        System.out.println(i);
    }

    @Test
    public void test3() {
        ProductBace productBace = new ProductBace();
        productBace.setPname("【最家】非洲菊仿真花干花");
        productBace.setPdetial("【破损补寄】【适合放室内、卧室、书房、餐桌、办公室、客厅、电视柜等地方】【无理由退换货】【包邮】【白色现代简约花瓶】");
        productBace.setBeginTime(TimeUtil.getNow());
        productBace.setUpdateTime(TimeUtil.getNow());
        productBace.setPrice(59.00);
        productBace.setPnumber(1000l);
        productBace.setPictures("");
        productBace.setCidone(3);
        productBace.setCidtwo(1);
        productMapper.addProductBace(productBace);
        System.out.println(productBace.getPid());
    }

    @Test
    public void testTimeUtil() {
        String now = TimeUtil.getNow();
        System.out.println(now);
    }

    @Test
    public void testCate() {
        QueryResponseResult<Category> oneCategory = categoryService.findOneCategory();
        System.out.println(oneCategory);
    }
}
