package test5;

/**
 * @ClassName ScalaDemo-Superman
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日21:47 - 周四
 * @Describe
 */
public class Superman extends Person{

    public Superman(){
        name = "超人";
    }

    @Override
    public int getPower() {
        return 100;
    }
}
