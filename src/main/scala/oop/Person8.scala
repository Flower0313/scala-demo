package oop

/**
 * @ClassName ScalaDemo-Person8 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日22:58 - 周五
 * @Describe 匿名子类
 */
abstract class Person8 {
  val name: String

  def hello(): Unit
}

object Test6 {
  def main(args: Array[String]): Unit = {
    //只有抽象类需要被重写才用匿名类,实际上是多态的写法，因为以多态的写法父类是无法调用子类的独有方法的，只会调用
    //子类的重写方法
    val person = new Person8 {
      override val name = "flower"

      val sex: String = "男"

      override def hello(): Unit = {
        println("哈哈")
        println(s"${name}是${sex}的")
      }

    }
    person.hello()

  }
}