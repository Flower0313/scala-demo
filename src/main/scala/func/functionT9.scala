package func

import scala.collection.mutable.ArrayBuffer

/**
 * @ClassName ScalaDemo-functionT9 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日19:12 - 周四
 * @Describe 高阶函数的案例
 */
object functionT9 {
  def main(args: Array[String]): Unit = {
    //功能1.map映射,参数一为String集合，参数二为输入类型和输出类型都为Int的函数
    def map(arr: Array[Int], op: Int => Int) = {
      for (elem <- arr) yield op(elem) //将1,2,3,4变成2,4,9,16
    }

    val arr = map(Array(1, 2, 3, 4), (x: Int) => {
      //匿名函数的实现方法：x的平方
      x * x
    })

    println("功能一：" + arr.mkString(","))


    //功能2：filter过滤，有参数，且参数在后面只使用一次，则参数省略且后面参数用_表示
    def filter(arr: Array[Int], op: Int => Boolean) = {
      var arr1: ArrayBuffer[Int] = ArrayBuffer[Int]()
      //if后面为ture就执行append
      for (elem <- arr if op(elem)) {
        arr1.append(elem)
      }
      arr1.toArray
    }

    def isMatch(s: Int): Boolean = {
      s % 2 == 1
    }

    var arr0 = filter(Array(1, 2, 3, 4), isMatch)
    var arr1 = filter(Array(1, 2, 3, 4), (x: Int) => x % 2 == 1)
    println("功能二：" + arr1.mkString(","))
    //简化后
    //var arr2 = filter(Array(1, 2, 3, 4), _ % 2 == 1)

    //功能3：reduce聚合，有多个参数，且每个参数再后面只使用一次，则参数省略且后面参数用_表示，第n个代表第n个参数
    def reduce(arr: Array[Int], opp: (Int, Int) => Int) = {
      var init: Int = arr(0)
      //until的意思是1~arr.length-1
      for (elem <- 1 until arr.length) {
        //数组第一个数累乘到第n-1个数
        init = opp(init, elem)
      }
      init
    }

    val arr3 = reduce(Array(1, 2, 3, 4), (x, y) => x * y)
    //简化后版本
    //val arr4 = reduce(Array(1, 2, 3, 4), _ * _)
    println("功能三：" + arr3)

  }
}
