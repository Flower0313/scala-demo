package oop

/**
 * @ClassName ScalaDemo-Person11 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月16日21:53 - 周六
 * @Describe 特质1：动态混入
 */
class Person11 {

}

trait PersonTrait {
  //具体属性
  var name: String = "我是一个人"

  //具体方法
  def eat() = println("我在进食...")

  //抽象属性
  var age: Int

  //抽象方法
  def say(): Unit
}

trait SexTrait {
  var sex: String
}

//java中的类可以被extends
class Teacher4 extends PersonTrait with java.io.Serializable {
  override var age: Int = 23

  override def say(): Unit = println("老师正在讲课...")

  def showName():String={
    name
  }
}

object Test9 {
  def main(args: Array[String]): Unit = {
    val teacher = new Teacher4
    teacher.say()
    teacher.eat()
    println(teacher.showName())
    //teacher.sex，由于此时没继承PersonTrait,所以不能调用sex

    //动态混入：可灵活的扩展类的功能
    val t2 = new Teacher4 with SexTrait {
      override var sex: String = "男"
    }
    //调用混入trait的属性,就可以调用sex了
    println(t2.sex)
  }
}
