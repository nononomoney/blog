package com.mszlu.blog.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * 主数据源配置
 *
 * @author niujinpeng
 * @website: https://www.wdbyte.com
 * @date 2020/12/19
 */
//@Configuration
//@MapperScan(basePackages = {"com.mszlu.blog.dao.mapper.primary"}, sqlSessionFactoryRef = "systemSqlSessionFactory")
//public class SystemDataSourceConfig  {
//
//    @Primary
//    @Bean("systemDataSource")
//    // yaml文件中配置的数据源前缀
//    @ConfigurationProperties(prefix = "spring.datasource.system")
//    public DataSource getSystemDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean("systemSqlSessionFactory")
//    public SqlSessionFactory systemSqlSessionFactory(@Qualifier("systemDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        // 配置mapping所在目录
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/primary/*.xml"));
//        return bean.getObject();
//    }
//
//    @Primary
//    @Bean("systemSqlSessionTemplate")
//    public SqlSessionTemplate systemSqlSessionTemplate(@Qualifier("systemSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
