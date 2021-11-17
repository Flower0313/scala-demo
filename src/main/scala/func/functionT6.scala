package func

/**
 * @ClassName ScalaDemo-functionT6 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日13:42 - 周四
 * @Describe 函数可以作为参数进行传递，相等于c的函数指针
 */
object functionT6 {
  def main(args: Array[String]): Unit = {
    //声明一个叫f1的函数，它的参数也是函数
    def f1(a1: Int, a2: Int, func: (Int, Int) => Int): String = {
      //可以看到f1函数中又有一个函数func(int,int)，且这个函数的参数类型是两个Int类型，
      //func的返回值类型是Int类型，f1的返回值是String类型
      //请注意func接收到的函数的参数类型要和func中定义的参数类型相同
      val res: Int = func(a1, a2) //相当于return func(2,4),只是省略了return而已,这里func就等价于add，x=a,y=b
      "ok"
    }

    //声明add函数，其参数为a和b
    def add(a: Int, b: Int): Int = a + b

    //此传参过程等价于 val func: (Int,Int) => Int = add 这是一个方法转换成函数的方式
    println(f1(1, 3, add)) //自动推断出了返回值类型，所以相当于f1(add _)
    println(f1(4, 5, add _)) //将add函数作为整体赋值给func，使func也变成了一个函数，所以能在f1的func直接调用
    println(f1(7, 8, (x, y) => x + y))
    println(f1(5, 6, _ + _))
  }
}
