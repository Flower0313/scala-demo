package generic

import scala.reflect.ClassTag

/**
 * @ClassName ScalaDemo-GenericTest4 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日17:54 - 周二
 * @Describe 泛型特质
 */
object GenericTest4 {
  trait Logger[T] {
    val a: T

    def show(b: T)
  }

  object ConsoleLogger extends Logger[String] {
    override val a: String = "flower"

    override def show(b: String): Unit = {
      println(b)
    }
  }

  def main(args: Array[String]): Unit = {
    val pair1 = new Pair[Int](22, 33)
    val pair2 = new Pair[String]("aa", "bb")
    ConsoleLogger.show("abc")

  }

  class Pair[T](val a: T, val b: T) {

  }
}

