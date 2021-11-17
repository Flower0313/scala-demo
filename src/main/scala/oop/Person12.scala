package oop

/**
 * @ClassName ScalaDemo-Person12 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月16日22:49 - 周六
 * @Describe 特质2:继承冲突
 */

trait PersonTrait2 {
  //继承的多个trait具有相同属性则会报错
  val name: String = "人"

  def show(): Unit = {
    println("人()")
  }
}

trait Male {
  //注意，如果这里是var，那么子类override会报错
  val name: String = "男人"
  //子类直接赋值就行，不用override
  var age: Int = 0

  def show(): Unit = {
    println("男人()")
  }
}

class Woman {
  val name: String = "女人"

}

class Person12 extends Woman with Male with PersonTrait2 {
  override val name: String = "肖华"
  age = 23

  override def show(): Unit = {
    println("都不是()")
  }
}

object Test10 {
  def main(args: Array[String]): Unit = {
    /*
    * 当子类继承的父类和父特质中有相同的val，需要被override
    * 当冲突属性是var类型时，则重写无效，只能换名字
    * */
    var p1 = new Person12
    println(p1.name)
    println(p1.age)
    p1.show()
  }
}
