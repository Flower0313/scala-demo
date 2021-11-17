package loop

import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}

/**
 * @ClassName ScalaDemo-WhileLoo 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月09日8:56 - 周六
 * @Describe While循环
 */
object WhileLoop {
  def main(args: Array[String]): Unit = {
    var i = 1;
    while (i < 10) {
      println(i)
      i += 1
    }

    do {
      println(i)
      i -= 1
    } while (i > 0)

    //循环中断：采用异常的方式
    try {
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) throw new RuntimeException
      }
    } catch {
      case e =>
    }
    println("正常结束循环")

    //循环中断：采用scala自带函数退出循环
    Breaks.breakable(
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) Breaks.break()
      }
    )
    println("正常结束循环")

    //循环中断：对break省略
    breakable {
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) break
      }
    }
    println("正常结束循环")

    //循环中断：遍历循环10以内的数据，奇数打印，偶数跳过
    for (elem <- 1 to 10) {
      if (elem % 2 == 1) {
        println(elem)
      } else {
        println("continue")
      }
    }
    println("正常结束循环")

    for(i <- 1 to 9){
      for(j <- 1 to i){
        print(j+"*"+i+"="+(i*j)+"\t")
      }
      println()
    }
    println("九九乘法表")



  }
}
