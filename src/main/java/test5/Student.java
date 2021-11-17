package test5;

/**
 * @ClassName ScalaDemo-Student
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日21:46 - 周四
 * @Describe
 */
public class Student extends Person {

    public Student() {
        name = "学生";
    }

    @Override
    public int getPower() {
        return 10;
    }
}
