package collection.array

/**
 * @ClassName ScalaDemo-TestArray
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日14:52 - 周日
 * @Describe 不可变集合定义方式一
 */
object MutableArray1 {
  def main(args: Array[String]): Unit = {
    //1.数组定义
    val arr1 = new Array[Int](4)
    println(arr1.length)

    //2.1数组赋值
    arr1(3) = 13

    //2.2采用方法形式赋值
    arr1.update(0, 10)

    //3.1遍历数组
    println(arr1.mkString(","))
    //3.2普通遍历
    for (i <- arr1) {
      println(i)
    }

    //3.3简化遍历
    def printx(elem: Int) = {
      print(elem + "\t")
    }

    arr1.foreach(printx)
    println()
    //3.3.1简化lambda写法
    arr1.foreach((x) => print(x + "\t"))
    println()
    //3.3.2极简写法
    arr1.foreach(print(_))
    arr1.foreach(println)

    //4.增加元素（由于是不可变数组，增加元素其实产生的是新数组）
    println("arr1地址:" + arr1 + ",arr1长度:" + arr1.length)
    //在arr1尾部添加一个值为13的元素
    val arr2: Array[Int] = arr1 :+ 13
    println("arr2地址:" + arr2 + ",arr2长度:" + arr2.length)
    arr2.foreach((x) => print(x + "\t"))

    println("--------------------------------------------------------------------------------")

    //给数组新增一个元素会导致地址改变，这就体现了不可变，要变的话只能变数组
    println(arr1 :+ 133)
    println(arr1.+:(2))

    val arr3 = arr1 :+ 99 //在后面追加
    val arr4 = arr3.+:(4) //在前面追加
    arr4.foreach((x) => print(x + "\t"))


  }
}
