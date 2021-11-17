package c2

import scala.io.StdIn

/**
 * @ClassName ScalaDemo-Test04_Comment 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日16:02 - 周四
 * @Describe 输入
 */
object Test04_StdIn {
  def main(args: Array[String]): Unit = {
    print("姓名：")
    var name = StdIn.readLine()

    print("年龄：")
    var age = StdIn.readShort()

    print("薪水：")
    var salary = StdIn.readDouble()

    println(s"姓名:${name},年龄:${age},薪水:$salary")
  }
}
