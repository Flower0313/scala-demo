package test5;

/**
 * @ClassName ScalaDemo-Client
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日21:53 - 周四
 * @Describe
 */
public class Client {
    public static void main(String[] args) {
        Person student = new Student();
        student = new Uniform(student);
        System.out.println(student.getName());
        System.out.println(student.getPower());

    }
}
