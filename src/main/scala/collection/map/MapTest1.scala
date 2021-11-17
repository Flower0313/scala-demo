package collection.map

/**
 * @ClassName ScalaDemo-MapTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日10:19 - 周一
 * @Describe 不可变Map
 */
object MapTest1 {
  def main(args: Array[String]): Unit = {
    //1.创建不可变map
    val map: Map[String, Int] = Map("hello" -> 1, "world" -> 2)
    val map2: Map[String, Int] = Map(("hello", 1), ("flower", 313))
    val map3: Map[String, Int] = Map(("z", 3), ("a", 1), ("a", 2), ("c", 3), ("f", 4), ("d", 5))

    //2.遍历
    println(map)
    println(map.getClass) //class scala.collection.immutable.Map$Map2,只用的伴生对象
    map.foreach(print)
    //2.1遍历key
    val keys = map.keys
    keys.foreach(print)
    //2.2遍历values
    val values = map.values
    values.foreach(print)

    //4.key是无序不可重复度的
    println(map3) //打印出没有顺序
    //使用 get 访问 map 集合的数据，会返回特殊类型 Option(选项):有值（Some），无值(None)
    //5.获取a的value的值
    val option: Option[Int] = map3.get("a")
    println("option:" + option)

    //6.判断元素是否存在
    if (!(!map3.contains("m"))) {
      val value: Int = map3("m")
      println(value)
    }
    //7.如果没有为m的key就打印出10
    val i = map3.getOrElse("m", 10)
    println(i)
    //8.获取key为a的value值
    val i1 = map3("a")


    println(i1)
  }
}
