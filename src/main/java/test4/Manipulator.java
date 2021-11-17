package test4;

/**
 * @ClassName ScalaDemo-Manipulator
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日22:22 - 周二
 * @Describe
 */

class HasF{
    public void f(){
        System.out.println("HasF.f()");
    }
}

//类型擦除只会擦除到边界，如果没有边界则会擦除到Object,但是这样就抵消了泛型所带来的好处
public class Manipulator <T extends HasF>{
    private T obj;

    public Manipulator(T obj){
        this.obj = obj;
    }
    public void manipulate(){
        /*
        * 上面的 Manipulator 是一个泛型类，内部用一个泛型化的变量 obj，在 manipulate 方法中，
        * 调用了 obj 的方法 f()，但是这行代码无法编译。因为类型擦除，编译器不确定 obj 是否有 f() 方法。
        * 所以解决的办法就是给泛型一个边界，也就是<T extends HasF>
        * */
        obj.f();//无法编译，找不到符号
    }

    public static void main(String[] args) {
        HasF hasF = new HasF();
        Manipulator<HasF> mani = new Manipulator<>(hasF);
        mani.manipulate();

    }
}
