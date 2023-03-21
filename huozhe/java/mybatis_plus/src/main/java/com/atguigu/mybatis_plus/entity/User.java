package com.atguigu.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author ljm
 * @Date 2021/9/25 21:32
 * @Version 1.0
 */
@Data
public class User {

    private Long id;


    private String name;


    private Integer age;


    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

//    @TableLogic
//    private Integer deleted;



}
