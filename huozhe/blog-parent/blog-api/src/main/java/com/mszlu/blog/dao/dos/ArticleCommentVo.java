package com.mszlu.blog.dao.dos;

import lombok.Data;


@Data
public class ArticleCommentVo {

    private Integer id;

    private String content;

    private Long count;
}
