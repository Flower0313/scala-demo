package collection.array

import scala.collection.mutable.ArrayBuffer

/**
 * @ClassName ScalaDemo-ArrayTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日20:14 - 周日
 * @Describe 不可变数组和可变数组的转换
 */
class ArrayTest1 {

}

object ArrayTest1{
  def main(args: Array[String]): Unit = {
    //1.创建一个空的可变数组
    val arr1 = ArrayBuffer[Int]()

    //2.追加值
    arr1.append(1, 2, 3)

    //（3）ArrayBuffer ==> Array
    //（3.1）arr1.toArray 返回的结果是一个新的定长数组集合
    //（3.2）arr1 它没有变化
    val newArr = arr1.toArray
    println(newArr)//[I@17c68925
    println(arr1)//ArrayBuffer(1, 2, 3)

    //（4）Array ===> ArrayBuffer
    //（4.1）newArr.toBuffer 返回一个变长数组 newArr2
    //（4.2）newArr 没有任何变化，依然是定长数组
    val newArr2 = newArr.toBuffer
    newArr2.append(123)
    println(newArr2)//ArrayBuffer(1, 2, 3, 123)

  }
}
