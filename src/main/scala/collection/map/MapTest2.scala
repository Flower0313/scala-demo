package collection.map

import scala.collection.mutable

/**
 * @ClassName ScalaDemo-MapTest2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日10:30 - 周一
 * @Describe 可变Map
 */
object MapTest2 {
  def main(args: Array[String]): Unit = {
    //1.可变Map
    val map3: mutable.Map[String, Int] =
      mutable.Map(("z", 3), ("a", 1), ("a", 2), ("c", 3), ("f", 4), ("d", 5))
    val map4: mutable.Map[String, Int] = mutable.Map(("flower", 1),("d",313))
    val map13: mutable.Map[String, Int] = mutable.Map[String, Int]()
    //2.可变mapkey使用put方法放入元素,底层就是使用的update
    map3.put("y", 10)
    map3 += (("h", 3))
    println(map3)

    //3.修改
    map3.update("z", 20)
    map3("z") = 10
    println(map3)

    //4.删除
    map3.remove("z")
    map3 -= ("h")
    println(map3)

    //合并两个map
    val map5 = map3++map4
    println(map5)

    map3 ++= map4
    println(map3) //改变map3,map4没变，如果两个有相同的元素，map3会被覆盖


  }
}
