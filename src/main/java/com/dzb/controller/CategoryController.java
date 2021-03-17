package com.dzb.controller;

import com.dzb.domain.Category;
import com.dzb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/17 11:16
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // 查询新闻类别列表
    @RequestMapping(value = "/findCategoryList.action")
    public String findCategoryList(Model model) {
        List<Category> categoryList=categoryService.findCategoryList();
        if (categoryList != null) {
            model.addAttribute("categoryList", categoryList);
        }
        return "category/category_list";
    }

    //根据新闻类别ID查询新闻类别
    @RequestMapping(value = "/getCategoryById.action")
    public String getCategoryById(Integer categoryId,Model model) {
        Category category=categoryService.getCategoryById(categoryId);
        model.addAttribute("category", category);
        return "category/category_list";
    }

    //转向添加用户
    @RequestMapping(value="/toAddCategory.action")
    public String toAddUser(Model model){
        return "category/add_category";
    }

    //判断登录账号是否已存在
    @RequestMapping(value = "/checkCategoryName.action")
    @ResponseBody
    public Category checkCategoryName(@RequestBody Category category, Model model) {
        Category checkCategory = categoryService.getCategoryByCategoryName(category.getCategoryName());
        if (checkCategory!=null) {
            //登录账号已存在
            return checkCategory;
        }else{
            checkCategory=new Category();
            checkCategory.setCategoryId(0);
            return checkCategory;
        }
    }

    // 增加新闻类别
    @RequestMapping(value = "/addCategory.action",method = RequestMethod.POST)
    public String toAddCategory(Category category, Model model) {
        model.addAttribute("category", category);

        //检查新闻类别是否已存在
        Category checkCategory = categoryService.getCategoryByCategoryName(category.getCategoryName());

        if (checkCategory!=null) {
            // 新闻类别已存在，重新转回添加新闻类别页面
            model.addAttribute("checkCategoryNameMsg", "新闻类别已存在，请重新输入");
            return "category/add_category";
        }else{
            // 新闻类别可用
            //调用UserService实例中的添加新闻类别方法
            int rows = categoryService.addCategory(category);
            if (rows > 0) {
                // 添加成功，转向新闻类别列表页面
                return "redirect:findCategoryList.action";
            } else {
                // 添加失败，重新转回添加新闻类别页面
                return "category/add_category";
            }
        }
    }

    // 转向修改新闻类别页面
    @RequestMapping(value = "/toEditCategory.action")
    public String toEditCategory(Integer categoryId, Model model) {
        //通过categoryId获取新闻类别
        Category category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            model.addAttribute("category", category);
            return "category/edit_category";
        }else{
            return "redirect:findCategoryList.action";
        }
    }

    //修改新闻类别
    @RequestMapping(value = "/editCategory.action", method = RequestMethod.POST)
    public String editCategory(Category category, Model model) {
        int rows = categoryService.editCategory(category);
        if (rows > 0) {
            // 添加成功，转向新闻类别列表页面
            return "redirect:findCategoryList.action";
        } else {
            model.addAttribute("category", category);
            // 修改失败，转回修改新闻类别页面
            return "category/edit_category";
        }
    }

    //删除新闻类别（前台页面中通过ajax方式调用此方法）
    @RequestMapping(value = "/delCategory.action")
    @ResponseBody
    public Category delCategory(@RequestBody Category category, Model model) {
        int rows = categoryService.delCategory(category.getCategoryId());
        if (rows>0) {
            return category;
        }else{
            //此处设置userId为0，只是作为操作失败的标记用
            category.setCategoryId(0);
            return category;
        }
    }
}
