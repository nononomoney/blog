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


public class Singleton5 {
    private static Singleton5 instance;
    private Singleton5() {

    }
    public static Singleton5 getInstance() {
        //https://blog.csdn.net/luoweifu/article/details/46613015  synchronized用法
        //安全问题已经解决但是我需要解决效率问题加个null判断
        if(instance == null) {
            synchronized(Singleton5.class){
                if (instance == null) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5();
                }
            }

        }


        return instance;
    }
}
