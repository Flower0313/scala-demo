package collection.list

/**
 * @ClassName ScalaDemo-ListTest7 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日19:00 - 周一
 * @Describe 集合计算高级函数（二）之Reduce规约
 */
object ReduceTest {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4)
    val list2 = List(3, 4, 5, 8, 10)

    //1.reduce:默认是reduceLeft
    val i: Int = list.reduce((x, y) => x - y)
    //println(list.re) 简化写法
    println("i=" + i)

    //reduceLeft:(((1-2)-3)-4) = -8
    val i1 = list.reduceLeft((x, y) => x - y)
    println(i1)

    //reduceRight:1-(2-(3-4))duce(_ - _) = -2
    val i2 = list.reduceRight((x, y) => x - y)
    println(i2)

    val i3 = list2.reduceRight((x, y) => x - y) //3, 4, 5, 8, 10
    println(i3) //3-(4-(5-(8-10))) = 6

    /*
    *
    * def reduceRight[B >: A](op: (A, B) => B): B =
    * if (isEmpty) throw new UnsupportedOperationException("Nil.reduceRight")
    * else if (tail.isEmpty) head
    * else op(head, tail.reduceRight(op)) //(head1 - (head2 - (head3- ...))
    * */
  }
}
