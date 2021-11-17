package collection.traversable

/**
 * @ClassName ScalaDemo-traversableT2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日20:10 - 周三
 * @Describe
 */
object traversableT2 {
  def main(args: Array[String]): Unit = {
    val t1: Traversable[Int] = Traversable.empty[Int]

    val t2: Traversable[Int] = Traversable[Int]()

    val t3: Traversable[Int] = Nil

    //比较他们集合中数据是否相同
    println(t1 == t2)
    println(t1 == t3)
    println(t3 == t2)

    //比较地址值是否相同
    println(t1 eq t2)
    println(t1 eq t3)
    println(t3 eq t2)

    //Traversable是一个特质，所以底层还是通过它的具体子类来实现的
    val t4 :Traversable[Int] = List(1,2,3).toTraversable
    val t5 = Set(1,2,3).toTraversable
    val t6 = Traversable(1,2,3,4)
    
    println(t5)//Set(1, 2, 3)
    println(t6)//List(1, 2, 3, 4)

  }

}
