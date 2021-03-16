package com.dzb.domain;

import java.io.Serializable;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/16 9:36
 */
public class Category implements Serializable {
    private Integer categoryId;
    private String categoryName;
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
    }
}
