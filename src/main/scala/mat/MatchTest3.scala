package mat

/**
 * @ClassName ScalaDemo-MatchTest3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日22:28 - 周一
 * @Describe 匹配常量
 */
object MatchTest3 {
  def main(args: Array[String]): Unit = {
    //匹配常量
    def func1(x: Any): String = x match {
      case 10 => "整数10"
      case 20.1 => "浮点数20.1"
      case 'x' => "字符x"
      case "hello" => "字符串hello"
      case _ => "其他数据"
    }

    println(func1(10))
    println(func1(20.1))
    println(func1('x'))
    println(func1("hello"))
    println(func1(180))
  }
}
