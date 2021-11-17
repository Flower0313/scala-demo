package collection.option

/**
 * @ClassName ScalaDemo-option_1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月30日16:07 - 周六
 * @Describe
 */
object option_1 {
  def main(args: Array[String]): Unit = {
    /*
    * Option[T] 是一个类型为 T 的可选值的容器： 如果值存在，
    * Option[T] 就是一个 Some[T] ，如果不存在， Option[T] 就是对象 None
    *
    * */
    val map: Map[String, Int] = Map(("a", 1), ("b", 2), ("c", 3))

    println(map.get("a") match {
      case Some(1) => "找到了"
      case _ => "滚蛋"
    })
    
    println(map.get("a") == Some(1))

  }
}
