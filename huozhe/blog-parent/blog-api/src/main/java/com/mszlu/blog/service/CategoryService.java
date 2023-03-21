package com.mszlu.blog.service;

import com.mszlu.blog.dao.dos.ArticleCommentVo;
import com.mszlu.blog.vo.CategoryVo;
import com.mszlu.blog.vo.Result;

import java.util.List;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    List<ArticleCommentVo> test();
}
