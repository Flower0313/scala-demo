package c2

import scala.runtime.Nothing$

/**
 * @ClassName ScalaDemo-Test06_DataType 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日16:59 - 周四
 * @Describe 数据类型
 */
object Test06_DataType {
  def main(args: Array[String]): Unit = {
    //1.整数类型,不能超过此范围
    var n1: Byte = 127
    var n2: Byte = -128
    var n3 = 313 //默认为Int类型
    var n4 = 1232142142112L
    var n5: Long = 123125123123L

    //这种可以通过，因为在编译时就是计算范围是否满足
    var n6: Byte = (10 + 20)
    println(n6)

    //这种则通不过，因为这是在运行时需要将n1、n2的值先拿过来计算才知道n7是否在范围内
    //var n7:Byte = (n1 + n2)

    //或者强制类型转换
    //var n8:Byte = (n1 + 10.toByte)
    //println(n8)


    //2.浮点类型
    var n9 = 2.2345678912f //Float
    var n10 = 2.2345678912 //Double


    //3.字符类型
    val c1: Char = '9'
    println(c1)

    //4.空类型
    def sayOk(): Unit = { // unit 表示没有返回值，即 void
      println("Unit被调用")
    }

    var a = sayOk()
    println("a=" + a)


    //null 可以赋值给任意引用类型（AnyRef），但是不能赋值给值类型 （AnyVal）
    var cat = new Cat();
    cat = null // 正确
    //var n1: Int = null // 错误
    println("n1:" + n1)

    //Nothing的值看不到
    //这里返回值写Int是因为Int是返回值n和Nothing的公共父类
    def m2(n: Int): Int = {
      if (n == 0)
        throw new NullPointerException
      else
        return n
    }

    var b = m2(133)
    println("b=" + b)


    //scala中的强制转换
    var num: Int = 2.7.toInt
    println(num)

    var s1: String = "313"
    var n12: Int = s1.toInt
    println(n12)


    var n: Int = 130
    var n13: Byte = n.toByte
    println(n13)


  }

  class Cat {
  }


}
