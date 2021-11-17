package collection

/**
 * @ClassName ScalaDemo-WordCount2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日18:31 - 周二
 * @Describe 复杂wordcount
 */
object WordCount2 {
  def main(args: Array[String]): Unit = {
    val tuples = List(("Hello Scala Spark World", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))

    /*
    * ================第一步
    * */
    val wordToCountList: List[(String, Int)] = tuples.flatMap {
      //这个t就是一个元组，tuples中有4个元组
      t => {
        //根据元组的第一个元素来拆分，此过程会执行4次，每次传进来一个元组，所以每次的t._2都是固定的
        //第一行strings就是Array[String]("Hello", "Scala", "Spark", "World")，根据空格拆分成这样
        val strings: Array[String] = t._1.split(" ")
        //第一次经过map方法后变成了 (Hello,4)(Scala,4)(Spark,4)(World,4)
        strings.map(word => (word, t._2))
      }
      //经过四次后将4个重新生成元组扁平化为一个List
    }
    /*
     * 第一步结果
    wordToCountList:List((Hello,4), (Scala,4), (Spark,4), (World,4), (Hello,3), (Scala,3), (Spark,3),
    *  (Hello,2), (Scala,2), (Hello,1))*/
    /*
    * ================第二步：
    * 根据List中元组的第一个参数来进行分组，也就是名字，t是一个元组比如:(Hello,4)，那t._1就是Hello
    * groupBy返回值肯定是一个Map[T,E]的类型
    * */
    val wordToTupleMap: Map[String, List[(String, Int)]] = wordToCountList.groupBy(t => t._1)
    /*
    * 第二步结果：
    * Map(Hello -> List((Hello,4), (Hello,3), (Hello,2), (Hello,1)), Spark -> List((Spark,4), (Spark,3)),
    * Scala -> List((Scala,4), (Scala,3), (Scala,2)), World -> List((World,4)))
    * */


    /*
     * ================第三步：
     * 对Map的values值进行处理，x能调用map完全是因为它是List类型
     * 这段代码的意思就是将map的values值中每个元组的第二个参数合起来
     * */
    val stringToInts: Map[String, List[Int]] = wordToTupleMap.mapValues(x => x.map(t => t._2))
    println(stringToInts)
    //Map(Hello -> List(4, 3, 2, 1), Spark -> List(4, 3), Scala -> List(4, 3, 2), World -> List(4))

    //或者这样
    val strings: List[String] = tuples.map(
      kv => {
        (kv._1.trim + " ") * kv._2
      }
    )
    val tuples1 = strings.flatMap(_.split(" "))
      .groupBy(word => word)
      .map(kv => (kv._1, kv._2.size))
      .toList
      .sortBy(x => x._2)
    println(tuples1)

  }
}
