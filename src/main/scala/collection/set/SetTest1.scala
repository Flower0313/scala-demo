package collection.set

import scala.collection.immutable.HashSet


/**
 * @ClassName ScalaDemo-SetTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日9:53 - 周一
 * @Describe 不可变Set
 */
object SetTest1 {
  def main(args: Array[String]): Unit = {
    //1.创建set
    val set = Set(1, 2, 3, 4, 4, 4, 5, 6, 6) //Set(5, 1, 6, 2, 3, 4)

    //2.无序不可重复
    println(set)

    //3.默认hash set,注意导包正确
    println(set.isInstanceOf[HashSet[Int]])

    val hashSet: HashSet[Int] = HashSet(1, 2, 3, 4, 4, 4, 5, 6, 6) //Set(5, 1, 6, 2, 3, 4)
    println(hashSet)

    //不可变set添加元素方法
    val set2 = set + 313
    println(set2)//Set(5, 1, 6, 2, 313, 3, 4)

    val bool: Boolean = set.contains(13)
  }
}
