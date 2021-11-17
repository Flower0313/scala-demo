package collection.set

import scala.collection.mutable
import scala.collection.mutable.HashSet


/**
 * @ClassName ScalaDemo-SetTest2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日10:08 - 周一
 * @Describe 可变Set
 */
object SetTest2 {
  def main(args: Array[String]): Unit = {
    //1.创建
    val set = mutable.Set(1, 2, 3, 4, 4, 4, 5, 6, 6)
    val hashSet: mutable.HashSet[Int] = HashSet(1, 2, 3, 4, 4, 4, 5, 6, 6)

    println(set)
    println(hashSet)

    //2.添加元素
    //会使用返回值来告诉你有没有加入进去,注意只有可变的set才能用+=和add
    set.+=(33)
    set += 13
    set.add(333)
    //光 + 是不改变原集合内容的是，需要新集合去接收
    val set2 = set + 88
    var bool = set.add(313)
    println(set2)

    //3.遍历
    set.foreach(print)

    //4.删除
    set.remove(3)
    println(set)
  }
}
