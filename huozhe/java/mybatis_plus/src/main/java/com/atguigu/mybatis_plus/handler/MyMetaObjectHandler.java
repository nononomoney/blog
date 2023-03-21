package com.atguigu.mybatis_plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author ljm
 * @Date 2021/9/26 19:49
 * @Version 1.0
 */
// spring初始化对象，Component表示注解类的对象就会自动被spring初始化出来
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("insertfill=====");
        //对象赋值
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("updatefill=====");
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
}
