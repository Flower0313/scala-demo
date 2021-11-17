package oop

/**
 * @ClassName ScalaDemo-VisitPower 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日18:32 - 周五
 * @Describe 访问权限
 */

//父类
class Student {
  private var name: String = "flower"
  protected var age: Int = 18
  private[oop] var sex: String = "男"

  def say() = {
    println(name)
    //伴生类中可以通过<伴生对象.属性>的方式调用伴生对象中的属性(包括私有属性)
    println(Student.pri_num)
  }
}

//Student的伴生对象
object Student {
  private var pri_num: Int = 313

  def main(args: Array[String]): Unit = {
    val student = new Student()
    student.say()
    println(student.name)

    //因为这是伴生对象，所以能调用私有属性age
    println(student.age)
  }

  //伴生对象中可以通过<new 伴生类().属性>的方式调用伴生类中的属性(包括私有属性)
  println(new Student().age)
}

class maleStudent extends Student {

  def test() = {
    //子类不能访问父类的私有属性
    println(age)
    println(sex)
    say()
  }
}

class Animal {
  def test = {
    //这里调不到name和age，尽管sex是私有字段，但Animal在oop包下，所以也可以访问
    new Student().sex
  }
}