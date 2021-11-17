package loop

/**
 * @ClassName ScalaDemo-ForLoop 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月08日23:37 - 周五
 * @Describe For循环
 */
object ForLoop {
  def main(args: Array[String]): Unit = {
    //1到3,实际是1.to(3)
    for (i <- 1 to 3) {
      print(i + " ")
    }
    println()

    //1到2
    for (j <- 1 until 3) {
      print(j + " ")
    }
    println()

    //这个条件相当于continue，为true就执行循环体内部
    //1 3
    for (i1 <- 1 to 3 if i1 != 2) {
      print(i1 + " ")
    }
    println()

    //按2的步长来增加,当然步长可以填写负数
    //1 3 5 7 9
    for (i2 <- 1 to 10 by 2) {
      print(i2 + " ")
    }
    println()

    //嵌套循环
    for (i3 <- 1 to 3; j1 <- 1 to 3) {
      println("i3 = " + i3 + "j1 =" + j1)
    }

    //引入j2变量
    for (i4 <- 1 to 3; j2 = 4 - i4) {
      print(j2 + " ")
    }
    println()

    //反转循环
    for (i5 <- 1 to 10 reverse) {
      print(i5 + " ")
    }
    println()

    for (i <- 4 to 0 by -1) {
      print(i + "\t")
    }

    //循环返回值
    val res = for (i <- 1 to 10) yield i
    println("res" + res)

    def operation(num: Int): Unit = {
      var res = for (i <- 1 to num) yield {
        i * 2
      }
      println(res)
    }

    operation(5)


    //99乘法表
    for (i <- 1 to 9; j <- 1 to i) {
      print(s"$i * $j=" + i * j + "\t")
      if (i == j) println()
    }

    //九层塔
    /*
    *   *
    *  ***
    * *****
    * */
    val line: Int = 5
    for (i <- 1 to line) {
      println(" " * (line - i) + "*" * (2 * i - 1))
    }
  }
}
