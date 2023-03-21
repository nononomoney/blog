package com.atguigu.mybatis_plus.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author ljm
 * @Date 2021/9/26 20:57
 * @Version 1.0
 */
//做事务处理
@EnableTransactionManagement
//配置类
@Configuration
public class MybatisPlusConfig {
    //spring当中可以被初始化出来的对象
    @Bean
    //乐观锁插件
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {

        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件

     */


    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();

    }


}
