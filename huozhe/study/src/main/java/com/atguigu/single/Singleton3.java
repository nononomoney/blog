package com.atguigu.single;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author ljm
 * @Date 2021/10/19 21:43
 * @Version 1.0
 *
 */

public class Singleton3 {

    //第一种方法在这个地方直接new
//    public static final Singleton3 INSTANCE = new Singleton3();
    //第二种方法
    //static 用法 https://blog.csdn.net/LIAO_7053/article/details/81408139?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link

    public static final  Singleton3 INSTANCE;
    private String info;
    static {
        Properties pro = new Properties();
        try {
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton3(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public Singleton3(String info) {
        this.info = info;
    }

    public static Singleton3 getINSTANCE() {
        return INSTANCE;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
