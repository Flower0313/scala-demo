package mat

/**
 * @ClassName ScalaDemo-MatchTest4 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日22:36 - 周一
 * @Describe 匹配类型
 */
object MatchTest4 {
  def main(args: Array[String]): Unit = {
    // 匹配类型
    def func2(x: Any): String = {
      x match {
        case i: Int => "整数" + i
        case c: Char => "字符" + c
        case s: String => "字符串" + s
        case list: List[Int] => "List集合" + list
        case _ => "其他"
      }
    }

    println(func2(1515))
    println(func2('\t'))
    println(func2("1515"))
    //List无法匹配是什么类型的List，只能匹配是List，因为泛型擦除
    println(func2(List(1, 2, 3, 4)))
    println(func2(List('1')))


  }
}
