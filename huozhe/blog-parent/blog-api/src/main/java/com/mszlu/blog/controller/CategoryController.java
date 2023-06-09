package com.mszlu.blog.controller;

import com.mszlu.blog.service.CategoryService;
import com.mszlu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ljm
 * @Date 2021/10/16 22:09
 * @Version 1.0
 */
@RestController
//文章分类
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result categories() {
        return categoryService.findAll();
    }

    @GetMapping("detail")
    public Result categoriesDetail() {
        return categoryService.findAllDetail();
    }

//localhost:8888/categorys/detail
//    @GetMapping("detail/{id}")
//    public Result categoryDetailById(@PathVariable("id") Long id) {
//        return categoryService.categoryDetailById(id);
//    }

}
