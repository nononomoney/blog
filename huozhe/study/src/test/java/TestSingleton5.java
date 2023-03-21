import com.atguigu.single.Singleton4;
import com.atguigu.single.Singleton5;

import java.util.concurrent.*;

/**
 * @Author ljm
 * @Date 2021/10/20 9:26
 * @Version 1.0
 */
public class TestSingleton5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Singleton4 s1 = Singleton4.getInstance();
//        Singleton4 s12 = Singleton4.getInstance();
//        System.out.println(s1 == s12);
//        System.out.println(s1);
//        System.out.println(s12);

        //Callable用法
        //https://ghsau.blog.csdn.net/article/details/7451464?spm=1001.2101.3001.6650.13&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EOPENSEARCH%7Edefault-13.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EOPENSEARCH%7Edefault-13.no_search_link
        // call 方法可以有返回值，run方法没有
        Callable<Singleton5> c = new Callable<Singleton5>() {
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };

        //创建两个线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = executor.submit(c);
        Future<Singleton5> f2 = executor.submit(c);

        Singleton5 s1 = f1.get();
        Singleton5 s2 = f2.get();

        //是有概率问题的一会true一会false
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        executor.shutdown();




    }
}
