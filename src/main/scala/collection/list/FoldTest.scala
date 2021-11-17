package collection.list

/**
 * @ClassName ScalaDemo-FoldTest 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日19:42 - 周一
 * @Describe Fold折叠，
 */
object FoldTest {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)

    // fold方法使用了函数柯里化，存在两个参数列表
    // 第一个参数列表为 ： 零值（初始值）
    // 第二个参数列表为： 简化规则
    //fold默认为foldLeft
    val i = list.foldLeft(1)((x, y) => x + y) //11 = 1+1+2+3+4
    val i1 = list.foldLeft(15)(_ - _) // ((((15-1)-2)-3)-4)=5
    val i3: (String, Int) = list.foldLeft(("和为", 0))((x, y) => (x._1, x._2 + y))//这里x就是("和为",0),运算逻辑就是第一个参数不变，第二个参数相加
    println(i3)

    //foldLeft的实现方法在TraversableOnce.scala中

    val i2 = list.foldRight(10)((x, y) => x - y) //(1-(2-(3-(4-10)))) = 8
    println(i2)
  }
}
