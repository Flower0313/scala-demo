package collection.traversable

/**
 * @ClassName ScalaDemo-traversableT1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日20:04 - 周三
 * @Describe 是所有集合的父特质,它也会可变和不可变
 */
object traversableT1 {
  def main(args: Array[String]): Unit = {
    //格式一:创建空的的Traversable对象

    //方式一
    val t1 = Traversable.empty[Int]
    //方式二
    val t2 = Traversable[Int]()
    //方式三
    val t3 = Nil


    //格式二：创建带参数的Traversable对象

    //方式一：
    val t4 = List(1, 2, 3).toTraversable
    //方式二
    val t5 = Traversable(1, 2, 3)




  }
}
