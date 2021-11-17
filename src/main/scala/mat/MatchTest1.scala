package mat

/**
 * @ClassName ScalaDemo-MatchTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日21:28 - 周一
 * @Describe 基本语法
 */
object MatchTest1 {
  def main(args: Array[String]): Unit = {
    var a: Int = 10
    var b: Int = 20
    var operator: Char = '+'

    var result = operator match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => "非法"
    }

    println(result)
  }
}
