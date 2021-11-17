package func

/**
 * @ClassName ScalaDemo-functionT13 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日0:49 - 周五
 * @Describe 惰性加载(懒加载)
 */
object functionT13 {
  def main(args: Array[String]): Unit = {
    //使用lazy关键字来声明
    lazy val res = sum(10, 30) //这里sum并不会立即执行
    println("1.函数调用")
    //可以看到sum在1.之后执行，因为下面的res中用到了该方法的返回值
    println("2.res=" + res)
    //这里并不会再执行3.了，因为res已经被赋值了
    println("4.res=" + res)
  }

  def sum(n1: Int, n2: Int): Int = {
    println("3.sum 被执行。。。")
    return n1 + n2
  }

}
