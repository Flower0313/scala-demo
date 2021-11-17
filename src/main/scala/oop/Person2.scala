package oop

/**
 * @ClassName ScalaDemo-Person2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日19:14 - 周五
 * @Describe val对象和var对象的区别
 */
class Person2 {
  var name: String = "canglaoshi"

  def show={
    println(this)
  }

}

object Person2 {
  def main(args: Array[String]): Unit = {
    //val修饰对象，不能改变对象的引用(内存地址)，可以改变属性的值
    val person1 = new Person2
    person1.name = "flower"
    person1.show

    println("person1:" + person1.name)

    var person2 = new Person2()
    person2.name = "xiaohua"
    println(person2)

    //person2将对象引用给person3,因为这是var类型，所以可以改变
    var person3 = new Person2()
    person3 = person2
    println(person3)

    //person1 = person2  会报错
  }
}
