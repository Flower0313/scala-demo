package oop

import scala.util.control.NonFatal

/**
 * @ClassName ScalaDemo-Person14 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月28日20:21 - 周四
 * @Describe
 */

abstract class Lover(var name: String) {

  def getName: String = name

  val age: Int = 313

  val loverThread = new Thread(name) {
    setDaemon(true)

    override def run(): Unit = {
      println("线程打开")
    }

  }
}

class manLover(name: String) extends Lover(name: String) {
  def shoeAge = {
    println(age)
  }
}

class Person14(name: String) {
  println(name)

  def show() = {
    println(name)
  }
}

class Baby(name: String) extends Person14(name: String) {

}

object testtest {
  def main(args: Array[String]): Unit = {
    //由此可以Baby会先调用父类的构造器方法
    val baby: Baby = new Baby("xiaohua")
    baby.show()

    //manLover也会执行父类的构造方法,再执行自己的
    val flower: manLover = new manLover("flower")
    println(flower.getName)
    flower.shoeAge
    flower.loverThread.run()
  }
}
