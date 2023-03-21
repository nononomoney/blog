package com.mszlu.blog.dao.mapper.primary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.dos.ArticleCommentVo;
import com.mszlu.blog.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ljm
 * @Date 2021/10/10 21:26
 * @Version 1.0
 */
public interface TestMapper extends BaseMapper<Article> {
   List<ArticleCommentVo> test();
}
