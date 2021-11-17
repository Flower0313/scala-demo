package collection.queue_other

/**
 * @ClassName ScalaDemo-OtherTest 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日21:20 - 周一
 * @Describe
 */
object OtherTest {
  def main(args: Array[String]): Unit = {
    val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}
    val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}

    println(result1)
    println(result2)

  }
}
