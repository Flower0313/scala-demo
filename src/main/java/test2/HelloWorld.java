package test2;

import java.util.HashSet;

/**
 * @ClassName ScalaDemo-HelloWorld
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日10:19 - 周日
 * @Describe scale中当一个object Hello继承了trait Talent所发生的事情
 * 对应了scala包下c1中HelloWorld
 */

interface Talent{
    void setterName(String aa);

    String name();

    //7.执行Module的setterName方法
    static void init(Talent tt){
        tt.setterName("flower");
    }
}
//伴生类HelloWorld
public final class HelloWorld implements Talent{
    public static HelloWorld Module;
    private String name;

    //2.执行静态代码块，new一个HelloWorld伴生类
    static {
        //3.去执行HelloWorld()构造方法
        new HelloWorld();
    }

    //4.执行构造方法
    private HelloWorld(){
        //5.将new的对象赋值给Module
        Module = this;
        //6.调用父接口的init方法，传递对象过去
        Talent.init(this);
    }

    public void main(){
        System.out.println("执行完成");
        System.out.println(Module);
    }


    //8.给name赋值
    @Override
    public void setterName(String aa) {
        this.name = aa;
    }

    @Override
    public String name() {
        return this.name;
    }
}

//伴生对象Hello
class Hello{
    public static void main(String[] args) {
        //1.调用静态Module的main方法
        HelloWorld.Module.main();
        //9.调用Module的name()方法
        System.out.println(HelloWorld.Module.name());

    }
}
