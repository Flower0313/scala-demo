package mat

/**
 * @ClassName ScalaDemo-MatchTest5 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日22:41 - 周一
 * @Describe 匹配数组
 */
object MatchTest5 {
  def main(args: Array[String]): Unit = {

    val arrays = List(Array(0), Array(1, 0),
      Array(0, 1, 0), Array(1, 1, 0),
      Array(1, 1, 0, 1), Array("hello", 90))

    //这样类似于正则表达式，判断顺序是从上到下依次判断，一旦有满足的跳过不再执行
    for (array <- arrays) {
      array match {
        case Array(0) => println("只有一个元素0的数组")
        case Array(1, _) => println("以1开头两个元素的数组")
        case Array(x, 1, y) => println(s"3个元素中间是1,左边是$x 右边是$y")
        case Array(x, y) => println(s"只有两个元素的数组  一个是 $x 一个是$y")
        case Array(1, _*) => println("第一个数是1，其余数量和类型完全不限制")
        case a: Array[Int] => println("整数数组")
      }
    }

  }
}
