package oop

/**
 * @ClassName ScalaDemo-Person3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日19:26 - 周五
 * @Describe 构造器
 */

//如果主构造器无参数，小括号可省略
class Person3() {
  var name: String = _ //默认值为null

  var age: Int = _



  def this(age: Int) {
    //调用主构造器，就是class Person3(),且第一行只能写一个this，第二行不能写this()
    //这是辅助构造器必须声明的
    this()
    this.age = age
    println("辅助构造器")
  }

  //辅助构造器
  def this(age: Int, name: String) {
    this(age)
    this.name = name
  }

  println("主构造器")
}

object Person3 {
  def main(args: Array[String]): Unit = {
    var person = new Person3(18)
  }
}
