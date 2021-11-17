package collection.tuple

/**
 * @ClassName ScalaDemo-TupleTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日11:49 - 周一
 * @Describe 元组
 */
object TupleTest1 {
  def main(args: Array[String]): Unit = {
    //1.声明
    val tuple: (Int, String, Boolean) = (40, "flower", true)

    //1.1嵌套元组
    val tuple2 = (("a", 1), ("b", 2)) //这样就相当于map了，元组中套有元组
    //val map = Map(("a",1), ("b",2), ("c",3))
    println(tuple2._1._1)
    println(tuple2.productElement(0))

    //2.1通过元素顺序访问
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
    //println(tuple._4) 超过访问会出错

    //2.2通过索引访问
    println(tuple.productElement(2))

    //2.3通过迭代器访问数据
    for (elem <- tuple.productIterator) {
      println(elem)
    }

    //3.map中键值对其实就是元组，只不过元组的元素个数为2,
    val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map1 = Map(("a", 1), ("b", 2), ("c", 3))
    map.foreach(tuple => {
      println(tuple._1 + "=" + tuple._2)
    })

  }
}
