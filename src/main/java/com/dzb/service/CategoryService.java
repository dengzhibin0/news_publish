package com.dzb.service;

import com.dzb.domain.Category;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/16 9:49
 */
public interface CategoryService {
    // 查询所有新闻类别
    public List<Category> findCategoryList();

    //根据新闻类别ID查询新闻类别
    public Category findCategoryById(Integer categoryId);
}
