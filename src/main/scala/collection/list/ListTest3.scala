package collection.list

/**
 * @ClassName ScalaDemo-ListTest3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日14:32 - 周一
 * @Describe 基本属性和常用属性
 */
object ListTest3 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7)

    //1.获取长度
    println(list.length)

    //2.获取集合大小，等同于length
    println(list.size)

    //3.循环遍历
    list.foreach(print)

    //4.迭代器
    for (elem <- list.iterator) {
      println("\t" + elem)
    }

    //5.生成字符串
    println(list.mkString(""))//1234567

    //6.是否包含
    println(list.contains(3))
  }
}
