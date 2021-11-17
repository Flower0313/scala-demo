package oop

import scala.util.parsing.json.JSON.flatten2

/**
 * @ClassName ScalaDemo-Person15 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年11月01日8:47 - 周一
 * @Describe
 */
class Person15(val name: String, val age: Int) {

  def this() = {
    this("佚名", 9999)
  }

  def show() = {
    println("已经被初始化" + name + ":" + age)
  }


}

object object_15 {
  def main(args: Array[String]): Unit = {

    //xiao是(String, Int) => Person15类型
    //输入一对元组，根据元组的参数来创建Person
    val xiao: (String, Int) => Person15 = {
      (x, y) => new Person15(x, y) //case (x, y) => new Person15(x, y)
    }
    val p = xiao("xiao", 313)
    p.show()

    def hua: Int => Int = {
      x => 313
    }

    println(hua(2))

  }

}
