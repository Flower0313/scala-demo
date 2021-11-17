package collection.array

/**
 * @ClassName ScalaDemo-MutableArray2
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日15:40 - 周日
 * @Describe 不可变集合定义方式二
 */
object MutableArray2 {
  def main(args: Array[String]): Unit = {
    val arr1 = Array(1, 3, 4, "flower")
    println("数组长度:" + arr1.length)
    arr1 :+ 0
    for (i <- arr1) {
      print(i + "\t")
    }
  }
}
