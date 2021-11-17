package oop

/**
 * @ClassName ScalaDemo-Person6 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日20:57 - 周五
 * @Describe 动态绑定(多态)
 *           因为在Java中父类以多态的形式new子类时，子类使用的还是父类的属性值，只有调用方法时才是子类自己的。
 */
class Person6 {
  val name: String = "person"

  def hello() = {
    println("hello person")
  }

  //方法可以省略成这样
  def hi = println("hi person")
}

class Teacher2 extends Person6 {
  //必须写override,不然name会报错
  override val name: String = "teacher"
  //同理
  override def hello() = {
    println("hello teacher")
  }
}


object Test4 {
  def main(args: Array[String]): Unit = {
    val teacher1 = new Teacher2()
    println(teacher1.name)
    teacher1.hello()
    teacher1.hi

    //以多态的形式声明Teacher2
    val teacher2: Person6 = new Teacher2()
    println(teacher2.name)
    teacher2.hello()
  }
}
