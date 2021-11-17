package collection.list

import scala.collection.mutable.ListBuffer

/**
 * @ClassName ScalaDemo-ListTest5 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日16:30 - 周一
 * @Describe 集合计算初级函数
 */
object ListTest5 {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 5, -3, 4, 2, -7, 6)
    val list1: ListBuffer[Int] = ListBuffer(1, 5, -3, 4, 2, -7, 6)
    val tuples = List(("hello", 10), ("world", 2), ("scala", 9), ("haha", 4), ("hello", 1))
    val list2 = List(("a", 5), ("b", 1), ("c", 8), ("d", 2), ("e", -3))

    //    （1）求和
    val sum: Int = list.sum
    println("sum:" + sum)

    //    （2）求乘积
    val product: Int = list.product
    println("乘积:" product)

    //    （3）最大值
    val max: Int = list.max
    println("max:" + max)
    println(list2.maxBy(x => x._2)) //list2.maxBy(_._2)

    //    （4）最小值
    val min: Int = list.min
    println("min:" + min)
    //    （5）排序,因为list不可变，所以要赋值给sorted
    val sorted = list.sorted
    println("before sorted:" + list)
    println("sorted:" + sorted)
    println(list2.sortBy(_._2))

    // 修改排序规则 从大到小
    val ints = list.sorted(Ordering[Int].reverse)
    println("reverse sorted:" + ints)

    //从小到大按值排序
    println(list2.sortBy(_._2))
    //从大到小排序
    println(list2.sortBy(_._2)(Ordering[Int].reverse))

    // 按照元组的默认字典序排列
    val sorted1: List[(String, Int)] = tuples.sorted
    println(sorted1)

    // 按照后面数字从小到大排序
    val tuples1: List[(String, Int)] = tuples.sortBy((tuple: (String, Int)) => tuple._2)
    println(tuples1)

    // 按照后面数字从大到小排序,会根据元组的个数来匹配不同的tupleX比较器,这里是tuple2
    val tuples2: List[(String, Int)] = tuples.sortBy((tuple: (String, Int)) => tuple._2)(Ordering[Int].reverse)
    println(tuples2)

    tuples.sortBy(_._2)

    // 自定义排序规则，底层基于二叉树
    val tuples3: List[(String, Int)] = tuples.sortWith((left: (String, Int), right: (String, Int)) => left._2 > right._2)
    println("自定义排序:" + tuples3)

    //省略写法
    val tuples4: List[(String, Int)] = tuples.sortWith(_._2 > _._2)
    println(tuples4)


  }
}
