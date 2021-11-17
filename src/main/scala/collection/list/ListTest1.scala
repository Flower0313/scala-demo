package collection.list


/**
 * @ClassName ScalaDemo-ListTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日20:36 - 周日
 * @Describe 不可变List
 */
object ListTest1 {
  def main(args: Array[String]): Unit = {
    //1.List默认为不可变集合
    //2.创建一个List
    val list1 = List(1, 2, 3, 4, 5)

    val list5 = Nil.::(13).::(2) //从右至左(2,13)
    val list6 = 7 :: 6 :: 5 :: 4 :: Nil //从左往右(7,6,5,4)


    //3.遍历数据
    //println(list1)
    //println(list1(1))
    //list1.foreach(x => println(x))

    //因为是不可变列表，改变长度必须用新容器来接新地址，所以每次添加元素和删除元素必须用一个新的容器来接
    val list2 = 0 +: list1 //在前面添加
    val list3 = list1 :+ 6 //在后面添加

    println(list3)

    val list4 = list3.::(7) //在前面添加
    println(list4)
    println("list5:" + list5)

    println("list6:" + list6)
    //合并list
    val list7 = list5 :: list6//List(List(2, 13), 7, 6, 5, 4)
    val list8 = list5 ::: list6//List(2, 13, 7, 6, 5, 4)
    println("list7:" + list7)
    println("list8:" + list8)
  }
}
