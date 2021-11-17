package oop

/**
 * @ClassName ScalaDemo-Person9 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日23:22 - 周五
 * @Describe 伴生对象--apply()
 */

//将类Person9私有化，在java中相当于私有化构造器,可以通过伴生对象调用
class Person9 private(cName: String) {
  private var age: Int = 19
  var name: String = cName

  //在伴生类中定义，用伴生对象调用也能实现
  def apply(): Unit ={
    println("apply")
  }
}

//伴生对象，可以将Person9中所以"静态"内容放在此处
//apply()方法是写在伴生对象中的
object Person9 {

  def apply(): Person9 = {
    println("apply空参")
    new Person9("xx") //最后一行相当于return new Person9("xx")
  }

  def apply(name: String): Person9 = {
    println("apply有参被调用")
    new Person9(name)
  }
  //这样也可以实现和apply一样的效果,但是调用的时候要
  def initPerson(name: String): Person9 = {
    println("hello,i am initPerson")
    new Person9(name)
  }
}

object Test7 {
  def main(args: Array[String]): Unit = {
    //1.通过伴生对象的apply方法，实现不使用new关键字创建对象
    //正常是Person9.apply() = Person9(),只是scala底层封装了，所以apply()可以省略
    val p1 = Person9() //这里是调用的伴生对象的apply的方法，然后由apply负责去调用Person9构造方法
    println("p1.name=" + p1.name)

    val p2 = Person9("flower")
    println("p2.name=" + p2.name)

    //val p3 = new Person9("xiaohua");这里直接调用Person9的构造方法

    val p3 = Person9.initPerson("xiaohua")
    println("p3.name=" + p3.name)
  }
}
