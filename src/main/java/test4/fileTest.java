package test4;

import java.io.*;

/**
 * @ClassName ScalaDemo-fileTest
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日19:57 - 周四
 * @Describe
 */
public class fileTest {
    public static void main(String[] args) throws IOException {
        Person p = new Student();
        System.out.println(p.name);
    }
}

class Person {
    public String name;

    public Person() {
        name = "人";
    }

    public void show() {
        System.out.println("我是人");
    }
}

class Student extends Person {
    public Student() {
        name = "学生";
    }

    @Override
    public void show() {
        System.out.println("我是学生");
    }
}
