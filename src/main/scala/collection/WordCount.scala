package collection

/**
 * @ClassName ScalaDemo-WordCount 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日20:25 - 周一
 * @Describe 简单的wordcount
 */
object WordCount {
  def main(args: Array[String]): Unit = {
    //单词计数：将集合中出现的相同的单词，进行计数，取计数排名前三的结果
    val stringList = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")


    //1.将每一行字符串转换成一个单词
    val strings = stringList.flatMap(_.split(" "))
    println(strings)

    //2.分组,根据自身的名字来分组
    val wordGroup: Map[String, List[String]] = strings.groupBy(word => word)
    println(wordGroup)

    //3.计数
    //由于wordGroup是map类型，而map里面其实就是元组,参数一是String，而参数二是List
    /*wordGroup.foreach(x => {
      println(x._1 + ":" + x._2.size)
    }) //这样只能查询，我们需要将查询的结果存入一个集合中，这时候就要用到map来转换了*/

    //只写一个参数就是List,两个参数就是Map
    val stringToInt = wordGroup.map(x => (x._1,x._2.size))
    println("map:" + stringToInt)

    //4.排序，比较value而不是key
    val sortedRes = stringToInt.toList.sortWith((l, r) => l._2 > r._2)

    //5.取前三名
    println(sortedRes.take(3))
  }
}
