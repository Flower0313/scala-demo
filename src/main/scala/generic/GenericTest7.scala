package generic

/**
 * @ClassName ScalaDemo-GenericTest7 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月23日0:50 - 周六
 * @Describe 泛型特质
 */

trait FLOWER[-A, +B] extends (A => B) {
  def show(x: A): Boolean

}

object FLOWER {

}

//泛型特质：在定义其子类或者子类单例对象的时候，明确具体的数据类型
trait Logger[T] {
  val a: T

  def show(b: T)
}

object GenericTest7 extends Logger[String] {
  def main(args: Array[String]): Unit = {
    show("flower")
  }

  override val a: String = "log"

  override def show(b: String): Unit = {
    println("打印日志" + b)
  }
}
