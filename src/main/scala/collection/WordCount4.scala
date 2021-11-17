package collection

/**
 * @ClassName ScalaDemo-WordCount4 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日20:57 - 周三
 * @Describe WordCount2简化版本
 */
object WordCount4 {
  def main(args: Array[String]): Unit = {
    val tuples = List(("Hello Scala Spark World", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))


    val list: Map[String, Int] = tuples
      .flatMap(t => t._1.split(" ")
        .map((_, t._2)))
      .groupBy(x => x._1)
      /*
      * t是List[String,Int]类型
      * x是Int类型，这是根据初始值的类型决定的
      * 这里y是(String,Int),因为这是根据源码中op(acc, this.head)决定的，
      * this.head决定y的类型,而this就是t
      * */
      .mapValues(t => t.foldLeft(0)((x, y) => x + y._2))
    //.mapValues(t => t.map(x => x._2).sum)


    println(list)

    /*println(
      tuples
        .map(x => (x._1 + " ") * x._2) //复制次数
        .flatten(_.split(" "))
        .groupBy(x => x) //这里不能化简成一个下划线，会有二义性
        .map(x => (x._1, x._2.length))
        .toList.sortWith(_._2 > _._2)
    )*/
  }
}
