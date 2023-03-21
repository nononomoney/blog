package com.atguigu.single;

/**
 * @Author ljm
 * @Date 2021/10/19 22:04
 * @Version 1.0
 * 懒汉式：
 * 延迟创建这个实例对象
 * (1)构造器私有化
 * （2）用一个静态变量保存这个唯一的实例
 * （3）要提供一个静态方法来获取这个实例对象
 */


public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4() {

    }
    public static Singleton4 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4();
        }
        return instance;
    }
}
