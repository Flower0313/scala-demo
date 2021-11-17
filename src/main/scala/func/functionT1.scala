package func

/**
 * @ClassName ScalaDemo-functionT 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日9:56 - 周四
 * @Describe
 */
object functionT1 {
  def main(): Unit = {
    show(313)
    show()
  }

  def main(args: Array[String]): Unit = {
    def f(args: String): Unit = {
      import java.util.Date
      println(args)
      main()
      println(new Date())
    }

    f("hello flower!")
  }

  def show(x: Int): Unit = {
    println(x)
  }
  def show(): Unit = {
    println("nothing")
  }

}
