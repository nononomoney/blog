package com.mszlu.blog;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * @Author ljm
 * @Date 2021/10/10 20:09
 * @Version 1.0
 */
@SpringBootApplication
public class BolgApp {
    public static void main(String[] args) {
        SpringApplication.run(BolgApp.class,args);
    }
}
