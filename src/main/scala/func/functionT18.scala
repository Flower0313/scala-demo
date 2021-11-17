package func

/**
 * @ClassName ScalaDemo-functionT18 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月24日12:27 - 周日
 * @Describe :=> 和 =>
 */
object functionT18 {
  def main(args: Array[String]): Unit = {
    val x: Int = 313
    println(withScope1(add(3)))
    println(withScope1(add(x)))


    println(withScope2(add))
    println(withScope2(x => x + 313))

  }

  def add(x: Int): Int = {
    x + 313
  }

  //名传递
  def withScope1(body: => Int): Int = {
    body
  }

  //接收一个定义完整的函数
  def withScope2(body: (Int => Int)): Int = {
    //因为是个完整有输入值的函数，所以这个必须有输入值
    body(313)
  }
}
