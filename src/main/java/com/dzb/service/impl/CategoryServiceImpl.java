package com.dzb.service.impl;

import com.dzb.dao.CategoryDao;
import com.dzb.domain.Category;
import com.dzb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/16 9:53
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    // 查询所有新闻类别
    @Override
    public List<Category> findCategoryList(){
        return this.categoryDao.selectCategoryList();
    }


    @Override
    public List<Category> findCategoryListByKeyword(String keyword) {
        return this.categoryDao.getCategoryByKeyword(keyword);
    }

    //根据新闻类别ID查询新闻类别
    @Override
    public Category getCategoryById(Integer categoryId){
        return this.categoryDao.getCategoryById(categoryId);
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        return this.categoryDao.getCategoryByCategoryName(categoryName);
    }

    @Override
    public int addCategory(Category category) {
        return this.categoryDao.addCategory(category);
    }

    @Override
    public int delCategory(Integer categoryId) {
        return categoryDao.delCategory(categoryId);
    }
}
