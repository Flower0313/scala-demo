package test5;

/**
 * @ClassName ScalaDemo-Person
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日21:32 - 周四
 * @Describe
 */
public abstract class Person {
    String name = "普通人";

    public String getName() {
        return name;
    }

    public abstract int getPower();
}


