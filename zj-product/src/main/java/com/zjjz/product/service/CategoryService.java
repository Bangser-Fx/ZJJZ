package com.zjjz.product.service;

import com.zjjz.common.exception.ExceptionCast;
import com.zjjz.common.model.CommonCode;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.QueryResult;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.Category;
import com.zjjz.product.mapper.CategoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 14:50
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 添加商品分类
     * @param category
     * @return
     */
    @Transactional
    public ResponseResult addCategory(Category category) {
        if(category==null || StringUtils.isBlank(category.getCname()) || category.getLevel()==null){
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        category.setCid(null);
        categoryMapper.addCategory(category);
        return ResponseResult.SUCCESS();
    }

    /**
     * 修改分类信息
     * @param category
     * @return
     */
    @Transactional
    public ResponseResult updateCategory(Category category) {
        if(category==null || category.getCid()==null){
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        categoryMapper.updateCategory(category);
        return ResponseResult.SUCCESS();
    }

    /**
     * 删除分类信息
     * @param cid
     * @return
     */
    @Transactional
    public ResponseResult deleteCategory(Integer cid) {
        categoryMapper.deleteCategory(cid);
        return ResponseResult.SUCCESS();
    }

    /**
     * 查询一级分类
     * @return
     */
    public QueryResponseResult<Category> findOneCategory() {
        List<Category> oneCategory = categoryMapper.findOneCategory();
        QueryResult<Category> result = new QueryResult<>();
        result.setList(oneCategory);
        result.setTotal(oneCategory.size());
        return new QueryResponseResult<>(CommonCode.SUCCESS,result);
    }

    /**
     * 查询二级分类
     * @return
     */
    public QueryResponseResult<Category> findTwoCategory() {
        List<Category> twoCategory = categoryMapper.findTwoCategory();
        QueryResult<Category> result = new QueryResult<>();
        result.setList(twoCategory);
        result.setTotal(twoCategory.size());
        return new QueryResponseResult<>(CommonCode.SUCCESS,result);
    }

    /**
     * 根据id获取分类信息
     * @param cid
     * @return
     */
    public QueryResponseResult<Category> getCategoryById(Integer cid) {
        Category category = categoryMapper.getCategoryById(cid);
        QueryResult<Category> result =new QueryResult<>();
        result.setObj(category);
        return new QueryResponseResult<>(CommonCode.SUCCESS,result);
    }
}
