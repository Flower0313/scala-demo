package mat

/**
 * @ClassName ScalaDemo-MatchTest6 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日22:58 - 周一
 * @Describe 匹配列表
 */
object MatchTest6 {
  def main(args: Array[String]): Unit = {
    //方式一
    for (list <- List(
      List(0), //for循环中第一个元素
      List(1, 0), //for循环中第二个元素
      List(0, 0, 0),
      List(1, 1, 0)
    )) {
      //match返回的是一个集合
      val result = list match {
        case List(0) => "0"
        case List(x, y) => "2个元素"
        case List(0, _*) => "第1个元素是0，后面不限"
        case _ => "其他"
      }
      result.foreach(print)
    }

    //方式二
    val list2 = List(1, 2, 5, 7, 24)
    list2 match {
      //双冒号是在原来基础上追加新元素，从右至左
      case first :: second :: rest =>
        println(s"first:${first},second:${second},rest:${rest}")
      //如果list2中只有一个元素就会走默认_
      case _ => println("其他")
    }

    //匹配泛型
    //如果匹配的是数组，能够匹配泛型
    def func1(x: AnyRef): String = x match {
      case i: Array[Int] => "泛型为整数"
      case c: Array[Char] => "泛型为字符"
      case s: Array[String] => "泛型为字符串"
      case _ => "其他"
    }

    println(func1(Array(1, 2, 3)))
    println(func1(Array('x', 'a')))
    println(func1(Array("hello")))

    // 泛型擦除
    def func2(x: AnyRef): String = {
      x match {
        case c: List[Char] => "泛型为字符"
        case s: List[String] => "泛型为字符串"
        case i: List[Int] => "泛型为整数"
        case _ => "其他"
      }
    }

    println(func2(List(1, 2, 3)))
    println(func2(List('c')))
    println(func2(List("hello")))
    println(func2(List(1.1)))

    // 特殊方法
    val list: List[Int] = List(1, 2, 5, 6, 7)

    list match {
      case first :: second :: rest => println(first + "-" + second + "-" + rest)
      case _ => println("something else")
    }


  }
}
