package com.dzb.dao;

import com.dzb.domain.Category;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/16 9:42
 */
public interface CategoryDao {
    // 查询所有新闻类别
    public List<Category> selectCategoryList();

    //根据新闻类别ID查询新闻类别
    public Category getCategoryById(Integer categoryId);
}
