package com.atguigu.mybatis_plus.mapper;

import com.atguigu.mybatis_plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author ljm
 * @Date 2021/9/25 21:34
 * @Version 1.0
 */
// https://www.jianshu.com/p/3942f6b4fa75   用法
@Repository
public interface UserMapper extends BaseMapper<User> {

}
