/**
 * @ClassName ScalaDemo-package
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日10:33 - 周五
 * @Describe
 */
//包对象
package object oop {
  val commonValue: String = "flower"

  def commonMethod() = {
    println(s"我们在${commonValue}")
  }
}
