package com.atguigu.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Author ljm
 * @Date 2021/9/26 20:21
 * @Version 1.0
 */
@Data
public class Product {


        private Long id;

        private String name;

        private Integer price;

        @Version
        private Integer version;

}
