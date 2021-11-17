package mat

/**
 * @ClassName ScalaDemo-MatchTest2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日22:07 - 周一
 * @Describe 模式守卫
 */
object MatchTest2 {
  def main(args: Array[String]): Unit = {
    def abs(x: Int) = x match {
      case i: Int if i >= 0 => i //第一个>=是大于等于，第二个>=是需要执行的内容，直接返回i
      case j: Int if j < 0 => -j //这里也可以用i
      case _ => "type illegal"
    }

    println(abs(-5))//5
    println(abs(0))//0
    println(abs(13))//13

  }
}
