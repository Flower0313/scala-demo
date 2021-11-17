package collection.list

/**
 * @ClassName ScalaDemo-ListTest4 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日14:38 - 周一
 * @Describe 衍生集合
 */
object ListTest4 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
    val list2: List[Int] = List(4, 5, 6, 7, 8, 9, 10)

    println("list1:" + list1)
    println("list2:" + list2)

    //1.获取集合的头
    println("hear:" + list1.head) //1

    //2.获取集合的尾
    println("tail:" + list1.tail) //List(2, 3, 4, 5, 6, 7)

    //3.集合最后一个数据
    println("last:" + list1.last) //7

    //4.集合初始数据(不含最后一个)
    println("init:" + list1.init) //List(1, 2, 3, 4, 5, 6)

    //5.反转
    println("reverse:" + list1.reverse) //List(7, 6, 5, 4, 3, 2, 1)

    //6.取前(后)n个元素
    println("take:" + list1.take(3)) //List(1, 2, 3)
    println("takeRight:" + list1.takeRight(3)) //List(5, 6, 7)

    //7.去掉前(后)n个元素
    println("drop(3):" + list1.drop(3)) //List(4, 5, 6, 7)
    println("dropRight(3):" + list1.dropRight(3)) //List(1, 2, 3, 4)

    //8.并集
    println("并集:" + list1.union(list2)) //List(1, 2, 3, 4, 5, 6, 7, 4, 5, 6, 7, 8, 9, 10)

    //9.交集
    println("交集:" + list1.intersect(list2)) //List(4, 5, 6, 7)

    //10.差集 list1有，而list2没有
    println("差集:" + list1.diff(list2)) //List(1, 2, 3)

    //11.拉链 注:如果两个集合的元素个数不相等，那么会将同等数量的数据进行拉链，多余的数据省略不用
    //list1和list2从头开始成对拼接
    println("拉链:" + list1.zip(list2)) //List((1,4), (2,5), (3,6), (4,7), (5,8), (6,9), (7,10))

    //12.滑窗
    for (elem <- list1.sliding(3)) { //默认步长为1
      println(elem)
    }

    list1.sliding(5, 4).foreach(println)
    /*
    * List(1, 2, 3, 4, 5, 6, 7) ,参数一表示窗口大小，参数二表示步长
    * (2,5)意思是按5个5个切分，这里切分成(1,2,3,4,5 |6,7)然后从每部分开头往后2个，就是(1,2)和(6,7)直到取到7
    * (5,2)意思就是按2个2个切分，(1,2 | 3,4 | 5,6 | 7)然后每部分开头往后取5个，(1,2,3,4,5)、(3,4,5,6,7)直到取到7
    * (4,4)，按2个切分,(1,2,3,4 | 5,6,7) 然后就是(1,2,3,4)和(5,6,7)
    * (3,2)分为(1,2,3)、(3,4,5)和(5,6,7)
    * (1,3)分为(1)、(4)、(7)
    * (5,4)分为(1,2,3,4,5)和(5,6,7)

    * */

  }
}
