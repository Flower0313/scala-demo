package c2

import scala.io.StdIn

/**
 * @ClassName ScalaDemo-Test08_ProcessControl 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月08日15:52 - 周五
 * @Describe
 */
object Test08_ProcessControl {
  def main(args: Array[String]): Unit = {
    print("请输入年龄：")
    var age = StdIn.readShort()
    //java中 String res = age<18 ? "童年" : "成年"
    //scala中的三元表达式
    val res: Any = if (age < 18) "童年" else "成年"
    println(res)
  }
}
