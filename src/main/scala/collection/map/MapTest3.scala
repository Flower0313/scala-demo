package collection.map

/**
 * @ClassName ScalaDemo-MapTest3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日19:51 - 周二
 * @Describe
 */
object MapTest3 {
  def main(args: Array[String]): Unit = {
    val map = Map("hello" -> List(("Hello", 4), ("Hello", 3)), "world" -> List(("world", 4), ("world", 3)))
    val map2 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val list = List(("Hello", 4), ("Hello", 3))

    //将map中的value拼接成啥样,x能调用map完全是因为它是List类型
    //它是将List(("Hello", 4), ("Hello", 3))作为一个整体来运行
    val stringToUnit = map.mapValues(x => x.map(t => t._2))
    println(stringToUnit)

    //List(("Hello", 4), ("Hello", 3))
    //意思是取出("Hello", 4), ("Hello", 3)，然后取他们的第二个元素加入到新List中
    val ints = list.map(t => t._2)
    println(ints)


    //将map中每个value值都加1
    val stringToInt = map2.mapValues(x => x + 1)
    //println(stringToInt)

  }
}
