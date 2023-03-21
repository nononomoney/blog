package com.atguigu.single;

/**
 * @Author ljm
 * @Date 2021/10/19 21:43
 * @Version 1.0
 * 饿汉式：
 * 在类初始化时直接创建实例对象，不管你是否需要这个对象都会创建
 *
 * (1)构造器私有化
 * (2)自行创建，并用静态变量保存
 * (3)向外提供这个实例
 * (4)强调这是一个单例，我们可以用final修改
 */

public class Singleton1 {
    // final 一旦赋值这个变量就不能再修改
    //static 用法 https://blog.csdn.net/LIAO_7053/article/details/81408139?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link
    //static final全局常量
    public static final Singleton1 INSTANCE = new Singleton1();
    public Singleton1() {
    }
}
