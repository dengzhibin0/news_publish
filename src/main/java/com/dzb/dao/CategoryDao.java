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

    // 根据关键词查询新闻类别列表
    public List<Category> getCategoryByKeyword(String keyword);

    //根据新闻类别ID查询新闻类别
    public Category getCategoryById(Integer categoryId);

    // 通过用户登录名查询用户
    public Category getCategoryByCategoryName(String categoryName);

    // 添加新闻类别
    public int addCategory(Category category);


    // 删除新闻类别
    public int delCategory(Integer categoryId);
}
