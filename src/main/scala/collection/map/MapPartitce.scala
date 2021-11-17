package collection.map

import scala.collection.mutable

/**
 * @ClassName ScalaDemo-MapPartitce 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月23日16:10 - 周六
 * @Describe
 */
object MapPartitce {
  def main(args: Array[String]): Unit = {
    //list.foldLeft(("和为", 0))((x, y) => (x._1, x._2 + y))//这里x就是("和为",0),运算逻辑就是第一个参数不变，第二个参数相加

    val map1 = mutable.Map(("hello", 1), ("scala", 2))
    val map2 = mutable.Map(("hello", 2), ("world", 3))

    //方式一
    /*val res = { //x是map2(初始值)，y是map1化成的(String,Int)元组，不断对map2累加，循环map1
      map1.foldLeft(map2)((m2, m1) => {
        println(m1._1 + "--" + m1._2)
        m2.put(m1._1, m1._2 + m2.getOrElse(m1._1, 0)) //put的操作逻辑是map2中有就直接累加，没有就创建
        m2
      })
    }
    println(res)*/


    //方式二：模式匹配
    val resMap = map1.foldLeft(map2) { //循环的是map1
      case (m2, m1_list) => { //m1_lsit是循环map1中的各个元组
        println(m2 + "||" + m1_list)
        m2(m1_list._1) = m2.getOrElse(m1_list._1, 0) + m1_list._2 //修改值,如果没有值添加进去
        m2
      }
    }
    println(resMap)


    //方式三：对不可变map进行聚合
    val map3 = Map(("hello", 1), ("scala", 2))
    val map4 = Map(("hello", 2), ("world", 3))

    val map: Map[String, Int] = map3.foldLeft(map4)((x, y) => {
      x.updated(y._1, y._2 + x.getOrElse(y._1, 0))
    })

  }
}
