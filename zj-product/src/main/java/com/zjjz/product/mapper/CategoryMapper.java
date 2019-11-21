package com.zjjz.product.mapper;

import com.zjjz.model.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 
* @author bangser
* @date 2019-10-29 20:57
* @version 1.0
**/
@Mapper
public interface CategoryMapper {
    /**
     * 查询所有商品类别
     * @return
     */
    List<Category> findAllCategory();

    /**
     * 查找一级分类
     * @return
     */
    List<Category> findOneCategory();

    /**
     * 查找二级分类
     * @return
     */
    List<Category> findTwoCategory();

    /**
     * 添加类别
     * @param category
     */
    void addCategory(Category category);

    /**
     * 修改分类信息
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 根据id删除分类
     * @param cid
     */
    void deleteCategory(Integer cid);

    /**
     * 根据id获取分类
     * @param cid
     */
    Category getCategoryById(Integer cid);
}