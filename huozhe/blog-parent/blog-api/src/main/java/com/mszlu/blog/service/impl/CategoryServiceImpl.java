package com.mszlu.blog.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszlu.blog.dao.dos.ArticleCommentVo;
import com.mszlu.blog.dao.mapper.primary.CategoryMapper;
import com.mszlu.blog.dao.mapper.primary.TestMapper;
import com.mszlu.blog.dao.pojo.Category;
import com.mszlu.blog.service.CategoryService;
import com.mszlu.blog.vo.CategoryVo;
import com.mszlu.blog.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ljm
 * @Date 2021/10/14 21:57
 * @Version 1.0
 */
@Service
@DS("test")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TestMapper testMapper;
    @Override
    public CategoryVo findCategoryById(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        categoryVo.setId(String.valueOf(category.getId()));
        return categoryVo;
    }

    @Override
    public Result findAll() {

        // 没有任何参数，所有一个空的LambdaQueryWrapper即可
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Category::getId,Category::getCategoryName);
        List<Category> categories = categoryMapper.selectList(queryWrapper);
        //页面交互的对象

        return Result.success(copyList(categories));
    }


    public CategoryVo copy(Category category){
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        categoryVo.setId(String.valueOf(category.getId()));
        return categoryVo;
    }
    public List<CategoryVo> copyList(List<Category> categoryList){
        List<CategoryVo> categoryVoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryVoList.add(copy(category));
        }
        return categoryVoList;
    }

    @Override
    public Result findAllDetail() {

        // 没有任何参数，所有一个空的LambdaQueryWrapper即可
        List<Category> categories = categoryMapper.selectList(new LambdaQueryWrapper<>());

        //页面交互的对象

        return Result.success(copyList(categories));
    }

//    @Override
//    public Result categoryDetailById(Long id) {
//        Category category = categoryMapper.selectById(id);
//        //转换为CategoryVo
//        return Result.success(copy(category));
//    }

    @Override
    public List<ArticleCommentVo> test() {
        return testMapper.test();
    }
}
