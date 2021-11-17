package mat

/**
 * @ClassName ScalaDemo-MatchTest7 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日23:00 - 周一
 * @Describe 匹配元组
 */
object MatchTest7 {
  def main(args: Array[String]): Unit = {
    //对一个元组集合进行遍历
    for (tuple <- Array((0, 1), (1, 0), (1, 1), (1, 0, 2))) {
      val result = tuple match {
        case (0, _) => "0..第一个元素是0的元组"
        case (y, 0) => "" + y + "0" //匹配最后一个元素是0的对偶元组
        case (a, b) => "" + a + " " + b //匹配两个元素的元组
        case _ => "something else" //默认
      }
      println(result)
    }

    //在变量声明中使用模式匹配
    val (x, y) = (3, 13) //x初值是3，y初值是13
    println(s"x:$x,y:$y")

    val (xh, lrx) = returnTuple
    println(s"xh:${xh},lrx:${lrx}")


    //必须加_*，如果不加则表示四个元素赋值给2个元素，后面多两个会报错
    val Array(first, second, _*) = Array(1, 7, 2, 9)
    println(s"first=$first,second=$second")

    val fir :: sec :: rest = List(23, 15, 9, 78)
    println(fir + " " + sec + " " + rest) //23 15 List(9, 78)

    /*val Person05(name, age) = Person05("zhangsan", 16)
    println(s"name=$name,age=$age")*/


    //在for中使用模式匹配
    //只遍历key
    for ((word, _) <- List(("a", 1), ("b", 2))) {
      println(word)
    }

    //打印出key为a的元组的value
    for (("a", count) <- List(("a", 1), ("b", 2), ("a", 13))) {
      println(count)
    }
  }

  def returnTuple = {
    (313, 515)
  }
}
