package com.mszlu.blog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration    //用于构建bean定义以及初始化Spring容器。
@EnableSwagger2   //开启Swagger2
public class SwaggerConifg {

    @Bean
    public Docket  docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("职位模块")
                .enable(true)  //配置是否启用Swagger，false游览器无法访问
                .select()  //通过select去配置扫描接口
                //RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.jzx.swagger.dome"))
                //通过path来过滤，扫描以"/position"开头的接口
                .paths(PathSelectors.ant("/position/*"))
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("用户模块")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jzx.swagger.dome"))
                .paths(PathSelectors.ant("/user/*"))
                .build();
    }

    private ApiInfo apiInfo(){

        Contact contact = new Contact("金正鑫", "http://localhost:8080/swagger-ui.html#/", "jinzhengxin2019@163.com");
        return new ApiInfo(
                "Swagger2 练习文档",    //标题
                "金正鑫",         //作者姓名
                "1.0",              //版本
                "http://localhost:8080/swagger-ui.html#/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}