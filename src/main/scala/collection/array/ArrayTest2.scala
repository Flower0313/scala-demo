package collection.array

/**
 * @ClassName ScalaDemo-ArrayTest2
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日20:30 - 周日
 * @Describe 多维数组
 */
object ArrayTest2 {
  def main(args: Array[String]): Unit = {
    //1.创建了一个二维数组，有三个元素,每个元素是都含有一个4个元素数组
    val arr = Array.ofDim[Int](3, 4)
    arr(1)(2) = 88

    //2.遍历二维数组
    for (i <- arr) { //i 就是一维数组
      for (j <- i) {
        print(j + " ")
      }
      println()
    }

    //3.遍历
    for (i <- arr.indices; j <- arr(i).indices) {
      print(arr(i)(j) + "\t")
      if (j == arr(i).length - 1) println()
    }
    //极简法
    arr.foreach(line=>line.foreach(print))
    arr.foreach(_.foreach(print))


  }
}
