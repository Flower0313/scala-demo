package c2

/**
 * @ClassName ScalaDemo-Test01_Domment 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日14:54 - 周四
 * @Describe 变量
 */

object Test01_Comment {
  def main(args: Array[String]): Unit = {
    var age = 18
    age = 20
    val sex = "male"

    var p1 = new Person()
    p1.name = "holden" //p1的属性能改变
    p1 = null //p1本身也能改变

    val p2 = new Person()
    p2.name = "flower" //p2的属性不能改
    //p2 = null p2本身不能改变，相当于改了地址
  }

}

class Person {
  var name: String = "xiaohua";
}
