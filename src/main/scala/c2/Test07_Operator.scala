package c2

/**
 * @ClassName ScalaDemo-Test07_Operator 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月08日15:06 - 周五
 * @Describe 运算符
 */
object Test07_Operator {
  def main(args: Array[String]): Unit = {
    var r1: Double = 10 / 3
    println(r1) //3.0
    var r2: Double = 10.0 / 3
    println(r2) //3.3333333
    println(r2.formatted("%.2f")) //3.33

    //以对象的方式调用运算符
    var r3: Int = 1.+(1)

    val n1: Int = 12
    val n2: Int = 37

    println(n1.+(n2))
    //不打空格编译器也会补空格，这就是省略了.的写法
    println(n1 + (n2))
    //在只有一个参数的前提下可以省掉小括号
    println(n1 + n2)

    //将7.5转换成int再转换成String
    println(7.5.toInt toString)
    println(r3)
  }
}
