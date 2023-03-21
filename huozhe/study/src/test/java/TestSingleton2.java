
import com.atguigu.single.Singleton2;

/**
 * @Author ljm
 * @Date 2021/10/19 22:09
 * @Version 1.0
 */
public class TestSingleton2 {
    public static void main(String[] args) {
        Singleton2 s = Singleton2.INSTANCE;
        System.out.println(s);
    }

}
