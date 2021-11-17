package collection.option

/**
 * @ClassName ScalaDemo-option_2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年11月02日0:53 - 周二
 * @Describe
 */
object option_2 {
  def main(args: Array[String]): Unit = {
    val a :Option[Int] = Some(5)
    val b :Option[Int] = None

    println(a.getOrElse(0))//5
    println(b.getOrElse(10))//10
  }
}
