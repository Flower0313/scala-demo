package collection.list

import scala.collection.mutable.ListBuffer

/**
 * @ClassName ScalaDemo-ListTest2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日22:49 - 周日
 * @Describe 可变ListBuffer
 */
object ListTest2 {
  def main(args: Array[String]): Unit = {
    //1.创建
    val buffer = ListBuffer(1, 2, 3, 4)
    val buffer2 = ListBuffer(5, 6, 7)

    //2.在后面追加，这里可知可变集合不用新的容器来接就可以增加元素
    buffer.+=(5)
    buffer.append(6)
    buffer.insert(1, 2) //指定位置添加
    0 +=: buffer //在前面添加
    buffer.prepend(-1)

    -100 +=: 30 +=: buffer += 22 + 98 //前面加2个后面加2个

    //3.修改数据
    buffer(1) = 313
    buffer.update(2, 333)

    //4.删除元素
    buffer.remove(2)
    buffer -= 313 //删除313

    //3.打印
    buffer.foreach(println)

    //4.合并list
    val list3 = buffer ++ buffer2
    println(list3)

    buffer ++= buffer2 //在buffer后边追加元素
    buffer ++=: buffer2 //在buffer2后边追加buffer
  }
}
