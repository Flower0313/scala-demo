package oop

/**
 * @ClassName ScalaDemo-Person7 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日21:34 - 周五
 * @Describe 抽象类
 */
abstract class Person7 {
  //抽象常量属性，java中的抽象类只有普通属性
  var age: Int
  val sex: String

  //抽象方法，只定义了参数列表和返回值
  def sleep(): Unit

  //非抽象属性
  val name: String = "person"
  var tall: Int = 176

  //非抽象方法
  def eat() = {
    println("person eat")
  }
}

class Teacher3 extends Person7 {
  //实现抽象 ,这里可以得出,重写抽象方法可以不声明override关键字,但都要实现
  //由于age抽象属性是var可变的，所以直接重写即可
  override var age = 19
  val sex: String = "男" //val是不可变参

  def sleep(): Unit = {
    println("teacher sleep")
  }

  //重写属性，非抽象的val属性重写的话需要加override
  override val name: String = "teacher"
  tall = 180 //非抽象的var属性可以直接覆盖
  //override var tall: Int = 180 ,这样写会报错，非抽象的var属性不能override,直接赋值就行

  override def eat(): Unit = {
    println("teacher eat")
  }

}

object Test5 {
  def main(args: Array[String]): Unit = {
    var teacher = new Teacher3()
    teacher.sleep()
    teacher.eat()
    println(teacher.name + "--" + teacher.age + "--" + teacher.tall)
  }
}
