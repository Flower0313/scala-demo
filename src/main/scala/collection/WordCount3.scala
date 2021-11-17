package collection

/**
 * @ClassName ScalaDemo-WordCount3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日20:49 - 周三
 * @Describe WordCount1的简化版本
 */
object WordCount3 {
  def main(args: Array[String]): Unit = {
    val stringList = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")
    println(stringList
      .flatMap(_.split(" ").map((_, 1)))
      .groupBy(_._1)
      .map(x => (x._1, x._2.size))
      .toList.sortWith(_._2 > _._2))
  }
}
