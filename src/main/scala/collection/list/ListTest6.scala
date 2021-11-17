package collection.list

/**
 * @ClassName ScalaDemo-ListTest6 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日17:58 - 周一
 * @Describe 集合计算高级函数（一）
 */
object ListTest6 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val wordList: List[String] = List("hello world", "hello atguigu", "hello scala")

    //println(list(1))//2
    //println(nestedList(0)(1))//2

    //1.过滤,函数类型就是Int=>Int
    println(list.filter(x => x % 2 == 0)) //List(2, 4, 6, 8)
    //list.filter(_ % 2 ==1)

    //2.转换/映射
    //println(list.map(x => x + 1)) //List(2, 3, 4, 5, 6, 7, 8, 9, 10)

    //3.扁平化,二合一
    val flatList = nestedList(0) ::: nestedList(1) ::: nestedList(2)
    //println(flatList)

    //println(nestedList.flatten) //List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    //4.扁平化+映射 注：flatMap相当于先进行map操作，在进行flatten操作,根据空格拆分
    //第一步
    val stringses: List[Array[String]] = wordList.map(_.split(" "))
    println(stringses)
    //第二步
    println(stringses.flatten)
    //一步到位
    println(wordList.flatMap(x => x.split(" "))) //List(hello, world, hello, atguigu, hello, scala)
    //println(wordList.flatMap(_.split(" ")))

    //5.分组，这里为啥是0和1分组呢？因为这里函数体是x%2,结果只有0和1,这里返回的类型是Map[Int,List[Int]]
    println(list.groupBy(x => x % 2)) //Map(1 -> List(1, 3, 5, 7, 9), 0 -> List(2, 4, 6, 8))
    //    println(list.groupBy(_ % 2))

    //groupMap2中groupBy中是Int => String类型的函数
    val groupMap2: Map[String, List[Int]] = list.groupBy((data => {
      if (data % 2 == 0) "偶数" else "奇数"
    }))
    println(groupMap2)

    //给定一组词汇，按照单词首字母进行分组
    val nameList = List("china", "america", "alice", "canada", "cary", "japan", "australia")

    val groupMap3 = nameList.groupBy(name => {
      name.take(1) //返回字符串首字母
    })
    println(groupMap3)

  }
}
