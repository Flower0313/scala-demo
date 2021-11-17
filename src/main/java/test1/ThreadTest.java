package test1;

/**
 * @ClassName ScalaDemo-ThreadTest
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年11月02日23:05 - 周二
 * @Describe
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("牛逼");
            }
        }).start();
    }
}
