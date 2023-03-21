package com.mszlu.blog.dao.mapper.primary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ljm
 * @Date 2021/10/10 21:26
 * @Version 1.0
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();

    //Page对象 是mybatisplus的page对象 代表要用到mybatisplus的一个分页
    //IPage也是mybatisplus的，代表我们自定义的分页查询
    IPage<Article> listArticle(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);

    IPage<Article> listTest(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);
}
