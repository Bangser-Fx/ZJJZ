package com.zjjz.product.controller;

import com.alibaba.fastjson.JSON;
import com.zjjz.api.product.CategoryController;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.Category;
import com.zjjz.product.service.CategoryService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 14:45
 **/
@RestController
@RequestMapping("/product/category")
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    @Override
    public ResponseResult addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/get/{cid}")
    @Override
    public QueryResponseResult<Category> getCategoryById(@PathVariable("cid") Integer cid) {
        return categoryService.getCategoryById(cid);
    }

    @PostMapping("/update")
    @Override
    public ResponseResult updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @GetMapping("/delete/{cid}")
    @Override
    public ResponseResult deleteCategory(@PathVariable("cid") Integer cid) {
        return categoryService.deleteCategory(cid);
    }

    @GetMapping("/findOneCategory")
    @Override
    public QueryResponseResult<Category> findOneCategory() {
        return categoryService.findOneCategory();
    }

    @GetMapping("/findTwoCategory")
    @Override
    public QueryResponseResult<Category> findTwoCategory() {
        return categoryService.findTwoCategory();
    }
}
