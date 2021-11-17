package test3;

/**
 * @ClassName ScalaDemo-Fanx
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日11:21 - 周二
 * @Describe 协变和逆变
 */
public class Fanx {
    public static void main(String[] args) {
        Object result = method(new Integer(2));//正确
        //Number result = method(new Object()); //error
        //Integer result = method(new Integer(2)); //error
    }

    static Number method(Number num){
        return 1;
    }
}


