package collection.array

import scala.collection.mutable.ArrayBuffer

/**
 * @ClassName ScalaDemo-ImmutableArray1
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日16:19 - 周日
 * @Describe 可变数组
 */
object ImmutableArray1 {
  def main(args: Array[String]): Unit = {
    //1.创建并赋值可变数组
    val arr1 = ArrayBuffer[Any](1, 2, 3)
    val arr11 = new ArrayBuffer[Int]()

    //2.遍历数组
    println(arr1)

    //3.增加元素
    //3.1追加数据然后赋值给newArr，此时两个地址是一样的，你改变newArr的元素的话，
    //arr1中的元素也能改变
    val newArr = arr1 += 19 //在后面追加
    77 +=: newArr //在前面追加
    println(arr1 == newArr)//true
    println(newArr)
    //arr1.+=(5)


    //3.2向数组最后追加99和100
    arr1.append(99, 100)

    println(arr1.hashCode())

    //3.3向指定的位置插入数据，在0号位置添加7和8
    arr1.insert(0, 7, 8)
    println("arr01.hash=" + arr1.hashCode())

    //4.修改元素
    arr1(1) = 9
    println("------------------------------------")

    //5.删除元素
    arr1.remove(3)

  }
}
