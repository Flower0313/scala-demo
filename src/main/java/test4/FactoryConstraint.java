package test4;

/**
 * @ClassName ScalaDemo-FactoryConstraint
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日22:39 - 周二
 * @Describe
 */

//定义接口
interface FactoryI<T> {
    T create();
}

class Foo2<T> {
    private T x;
    //构造方法最多擦除到FactoryI<T>
    public <F extends FactoryI<T>> Foo2(F factory) {
        System.out.println("构造方法");
        x = factory.create();
    }
}
//定义IntegerFactory工厂，只接收Integer
class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create() {
        return new Integer(0);
    }
}
class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}

