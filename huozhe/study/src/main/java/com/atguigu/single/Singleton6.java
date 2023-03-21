package com.atguigu.single;

/**
 * @Author ljm
 * @Date 2021/10/20 10:10
 * @Version 1.0
 * 在内部类被加载和初始化时，才创建INSTANCE
 * 静态类不会随着外部类的加载和初始化而初始化，它是要单独加载和初始化的
 * 因为在内部类加载和初始化时创建的因此是线程安全的
 */
public class Singleton6 {

    private Singleton6(){

    }
    private static class Inner{
        private static final  Singleton6 INSTANCE = new Singleton6();
    }
    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }
}
