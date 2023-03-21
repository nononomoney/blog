package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.Product;
import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.ProductMapper;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @Author ljm
 * @Date 2021/9/26 14:39
 * @Version 1.0
 */
@SpringBootTest
public class CRUDTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testInsert()  {

        User user = new User();
        user.setName("Helen");
        user.setEmail("1390202831@qq.com");
        user.setAge(18);
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        //返回影响行数
        int result = userMapper.insert(user);
        System.out.println("影响行数："+result);
        System.out.println("user id: "+user.getId());



    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(1442096182720491521L);
        user.setAge(28);
        user.setName("annie");
//        user.setUpdateTime(new Date());

        int result = userMapper.updateById(user);
        System.out.println("影响的行数:"+result);


    }

    @Test
    public void testConcurrentUpdate() {
        //1、 小李获取数据
        Product p1 = productMapper.selectById(1L);
        System.out.println("小李取出的价格"+p1.getPrice());

        // 2、 小王获取数据
        Product p2 = productMapper.selectById(1L);
        System.out.println("小王取出的价格"+p2.getPrice());

        // 3、小李加了50元存入数据库
        p1.setPrice(p1.getPrice()+50);
        productMapper.updateById(p1);


        // 4、小王减了30元存入数据库
        p2.setPrice(p2.getPrice()-30);
        int i = productMapper.updateById(p2);
        if (i==0) {
            System.out.println("小王更新失败");
            //发起重试
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() -30);
            productMapper.updateById(p2);

        }

        //5、其他人看到的结果.最后的结果
        Product p3 = productMapper.selectById(1L);
        System.out.println("" +
                "最后的结果"+p3.getPrice());

    }

    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","helen");
        map.put("age",18);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);



    }

    @Test
    public void testSelectPage(){


        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        queryWrapper.select("id","name");


        Page<Map<String,Object>> page = new Page<>(1, 5);

        Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, queryWrapper);

        List<Map<String, Object>> records = pageParam.getRecords();

        records.forEach(System.out::println);

        System.out.println(pageParam.getPages());//总页数
        System.out.println(pageParam.getTotal());//总记录数
        System.out.println(pageParam.getCurrent());//当前页码号
        System.out.println(pageParam.getSize());//每页记录数
        System.out.println(pageParam.hasNext());//是否有下一页
        System.out.println(pageParam.hasPrevious());//是否有上一页

    }

    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(5L);
        System.out.println("删除了"+i+"行");

    }

    @Test
    public void testDeleteBatchIds() {
        int i = userMapper.deleteBatchIds(Arrays.asList(10,11,12));
        System.out.println("删除了"+i+"行");

    }

    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","helen");
        map.put("age","18");

        int i = userMapper.deleteByMap(map);
        System.out.println("删除了"+i+"行");


    }

    @Test
    public void testLogicDelete(){
        int i = userMapper.deleteById(1L);
        System.out.println("删除了"+i+"行");
    }



}
