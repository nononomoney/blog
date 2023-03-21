package com.atguigu.step;

import org.junit.jupiter.api.Test;

/**
 * @Author ljm
 * @Date 2021/10/20 20:14
 * @Version 1.0
 */
public class TestStep {
    //实现f(n)：求n步台阶，一共有几种走法
    public int f(int n) {
        if (n<1) {
            throw new IllegalArgumentException(n+"不能小于1");
        }
        if (n == 1||n == 2){
            return n;
        }
        return f(n - 1)+f(n-2);
    }

    @Test
    public void test(){
        long start = System.currentTimeMillis();

        System.out.println(f(40));
        long end = System.currentTimeMillis();
        System.out.println(end - start);//259ms

    }

    public int loop(int n){
        if (n<1) {
            throw new IllegalArgumentException(n+"不能小于1");
        }
        if (n == 1||n == 2){
            return n;
        }
        int one = 2;//初始化走到第二节台阶走法
        int two =1;//初始化走到第一节台阶走法
        int sum=0;
        //最后跨两步加上最后跨一步
        for (int i = 3; i <=n; i++) {
            sum =two+one;
            two = one;
            one = sum;


        }
        return sum;
    }

    @Test
    public void test2(){
        long start = System.currentTimeMillis();
        System.out.println(loop(4));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
