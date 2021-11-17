package collection.list

import scala.collection.immutable
import scala.collection.mutable.ListBuffer

/**
 * @ClassName ScalaDemo-OtherTest 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日8:41 - 周三
 * @Describe 集合深入解读
 */
object OtherTest {
  def main(args: Array[String]): Unit = {
    //Array集合
    val array1 = Array("china", "canada", "japan", "america")
    //List集合
    val list1 = List(1, 2, 3, 4, 5, 6)
    val list2 = List("a bc", "ed f", "hi jk", "abol uo", "abandon", "ab c")
    val list3 = List(List("hello", "xiaohua"), List("hey", "flower"), List("bonjor", "zzx", "nini"))
    val list4: List[(String, Int)] = List(("Hello Scala Spark World", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))
    //Map集合
    val map1: Map[String, Int] = Map(("flower", 3), ("xiaohua", 13), ("holden", 1998))
    val map2: Map[Int, List[String]] = Map((1, List("abc", "def")), (2, List("ghi", "jkl")), (3, List("a", "b", "c")))
    //Tuple集合
    val tuple1 = (("a", 1), ("b", 2), ("c", 3), ("d", 4), ("e", 5))


    /*
    * 1.过滤
    * 一个新的可遍历集合，由这个可遍历集合中满足给定函数条件的所有元素组成，元素的顺序被保留下来。
    * 过滤的时候每个元素都会根据你传入的函数进行运算
    * filter()输出类型：Boolean类型,所以=>后面必须要写一个能生成bool值的逻辑操作
    * 可以看到下面返回的类型不同,但总类型还是和传入时相同
    * */
    //1.1 Array集合中字符数大于5的,返回的是Array类型
    val arrRes: Array[String] = array1.filter(x => x.length > 5) //这里x是字符类型
    //arrRes.foreach((x) => print(x + "\t"))

    //1.2 List集合中过滤使用,返回的是List类型
    val listRes1: List[Int] = list1.filter(x => x % 2 == 0) //List(2, 4, 6),这里x是Int类型
    val listRes2: List[String] = list2.filter(x => x.length > 3) //List(hijk, aboluo, abandon),这里x是String类型
    val listRes3: List[List[String]] = list3.filter(x => x.size > 2) //List(List(bonjor, zzx, nini)),这里x是List类型
    val listRes4: List[List[String]] = list3.filter(x => x.contains("flower")) //List(List(hey, flower)),找到集合中包含有flower的

    //List((Hello Scala Spark World,4), (Hello Scala Spark,3))，这里的x是元组类型,x._2是Int类型
    val listRes5: List[(String, Int)] = list4.filter(x => x._2 >= 3)
    //List((Hello Scala Spark World,4)),这里的x._1是String类型
    val listRes6: List[(String, Int)] = list4.filter(x => x._1.contains("World"))

    //1.3 Map集合中过滤使用,返回的是Map类型
    val mapRes1: Map[String, Int] = map1.filter(x => x._1.contains("flower")) //Map(flower -> 1),这里x是Map类型,x._1是String而x._2是Int

    //1.4 元组中过滤使用,元组类型是不可以使用filter的


    /*
    * 2.转换+/映射--------------------------------------------------
    * map中的参数一就是你的函数逻辑,但这里的参数二没有传入,所有底层会找寻隐式参数
    * map()输出类型：=>That 表示不确定，根据你的函数处理逻辑
    * 反正map只会按一个数据单元进行处理,map可以是类型的转换也可以是值的转换
    * */
    //2.1 此时x是String类型的,目的是将x复制成2份,然后再放入新集合
    val maps1: Array[String] = array1.map(x => x * 2) //chinachina,canadacanada,japanjapan,americaamerica

    //2.2 可以看到下面两者返回的类型不同，只是因为传入的逻辑不同,但总类型还是和传入时相同,为List
    val maps2_1: List[Int] = list1.map(x => x + 1) //List(2, 3, 4, 5, 6, 7)
    val maps2_2: List[(Int, Int)] = list1.map(x => (x, x + 1)) //List((1,2), (2,3), (3,4), (4,5), (5,6), (6,7))

    //2.3 由下面案例可知,用户可以根据自己的想法来组件输出的类型，比如我这里输入类型只是List中的一个String元素
    //但是经过我的逻辑，我将它组装成了一个元组的样子,第一个元素是将每个传入进来的元素加上_get
    //第二个元素是打上该元素的排名
    //这两个参数之中都是写了代码块(偏函数)，也就是代码块可以替代值，只有最后一行有返回值就行
    var count: Int = 0
    val tuples: List[(String, Int)] = list2.map(x => ( { //你想拼接成多个元素的元组都可以
      x + "_get" //return x + "_get"
    }, {
      count += 1
      count //return count
    }))
    //结果:List((abc_get,1), (edf_get,2), (hijk_get,3), (aboluo_get,4), (abandon_get,5), (abc_get,6))

    //2.4 这里x是List类型
    val maps3: List[Int] = list3.map(x => x.length) //List(2, 2, 3) 统计每个list中的个数，然后加入到List元素中

    //因为list3中每个元素是List，所以可以更进一步筛选，List元素中的元素是String，这时候可以用两层方法
    //List(List(xiaohua), List(flower), List(bonjor)) ,将List中List中String元素大于5的字符取出来
    val maps3_2: List[List[String]] = list3.map(x => x.filter(y => y.length > 5))

    //2.5 自定义返回的元素个数和类型，但大类型会和传入进来的一致
    var rank: Int = 0
    val maps3_3: List[(List[String], String, String)] = list3.map(x => (x,
      "元素有" + x.length + "个", {
      rank += 1
      "第" + rank + "组"
    })) //List((List(hello, xiaohua),元素有2个,第1组), (List(hey, flower),元素有2个,第2组), (List(bonjor, zzx, nini),元素有3个,第3组))

    //2.6
    val tuples1: List[(Array[String], Int)] = list4.map(x => (x._1.split(" "), x._2))
    /*for (elem <- tuples1.iterator) {
      println(elem._1.foreach(x => print(x + ",")) + "\t" + elem._2)
    }*/

    //2.7 给map类型调换key和value，输入类型是一个元组，返回的还是Map
    val stringToInt: Map[Int, String] = map1.map(x => (x._2, x._1))


    /*
    * 3.扁平化,二合一--------------------------------------------------
    * 扁平化默认只能扁平List集合，其Map和List内含Map的类型可以自己写逻辑扁平，元组不可调用flatten
    * flatten():输出类型是一定是Lsit[String | Char],其中是Int是无法扁平化的，因为归根结底扁平化就是根据字符来切割
    * */
    val flatten: Array[Char] = array1.flatten
    //list1中全是数字是无法被扁平化
    //lsit2.flatten默认安装每一个字符切割一次
    val flatten1: List[Char] = list2.flatten //List(a, b, c, e, d, f, h, i, j, k, a, b, o, l, u, o, a, b, a, n, d, o, n, a, b, c)

    //根据List中元素中的空格来切分，List中每个不同的元素都是一个独立的个体，比如"a bc"和"ed f"分别来切割，而不是组合起来再切割,比如list2会切割6次
    val strings: List[String] = list2.flatten(x => {
      //println("我在切割")
      x.split(" ")
    }) //List(a, bc, ed, f, hi, jk, abol, uo, abandon, ab, c)
    val flatten2: List[String] = list3.flatten //不管你几层List,都会扁平化为一层List,但保持顺序

    //默认情况下map扁平化不了(包括List中含有map)，除非自己写逻辑,比如下列将List的元组元素按照第一个元素的空格来切割,第二个元素不用管
    val strings1: List[String] = list4.flatten(x => x._1.split(" ")) //List(Hello, Scala, Spark, World, Hello, Scala, Spark, Hello, Scala, Hello)

    //对map元素的第一个元素来按照空格切割
    val strings4: immutable.Iterable[String] = map1.flatten(x => x._1.split(" ")) //List(flower, xiaohua, holden)

    /*
    * 4.扁平化+映射 --------------------------------------------------
    * flatMap相当于先进行map操作，在进行flatten操作集合中的每个元素的子元素映射到某个函数并返回新集合
    * 返回值类型一定要是集合类型
    *
    * */
    val strings2: List[String] = list2.flatMap(x => x.split(" ")) //List(a, bc, ed, f, hi, jk, abol, uo, abandon, ab, c)
    val list5 = List("1_2_ab,flower", "313_22_holden,xiao")


    /*
    * 5.分组--------------------------------------------------
    * groupBy():返回值类型一定是一个不可变的Map[K,V]类型
    *
    * */
    //根据元素的首字母分组
    //Map(e -> List(ed f), h -> List(hi jk), a -> List(a bc, abol uo, abandon, ab c))
    val group1: Map[String, List[String]] = list2.groupBy(x => x.take(1))

    //注意，当你List包含List时是不会被扁平化的，此时最小单元是List
    val stringsToList = list3.groupBy(x => x.take(1))

    
    //根据奇偶来分组,传入的是List[(String, Int)]类型，返回类型是Map[String,List[(String, Int)]]
    //可以看出返回类型的第一个参数和你的函数体返回类型有关,而参数二就是你的传入类型
    val group2: Map[String, List[(String, Int)]] = list4.groupBy(x => {
      if (x._2 % 2 == 0) "偶数" else "奇数"
    })

    //根据字符的个数来分组
    val group3: Map[Int, Map[String, Int]] = map1.groupBy(x => x._1.length)

    //根据List的长度来分组
    val group4: Map[Int, Map[Int, List[String]]] = map2.groupBy(x => x._2.length)
    //Map(2 -> Map(1 -> List(abc, def), 2 -> List(ghi, jkl)), 3 -> Map(3 -> List(a, b, c)))

    /*
    * map和flatmap的区别:
    * map是以List中每个元素为单位,而flatMap是以整个集合的最小元素为单位
    * */
    val stringses: List[Array[String]] = list2.map(x => x.split(" ")) //List(Array(a,bc),Array(ed,f))
    val strings3: List[String] = list2.flatMap(_.split(" ")) //List(a,bc,ed,f)

  }
}
object test {
  def main(args: Array[String]): Unit = {
    val list = List("1_2_ab,flower", "313_22_holden,xiao")

    val rddm: Seq[(String, Int)] = list.flatMap {
      x => {
        val datas: Array[String] = x.split("_")
        val strings: Array[String] = datas(2).split(",")
        //strings //是集合类型可以返回,返回后最后还是会被拆开
        strings.map(x => (x, 1)) //将(ab,flower)拆成(ab,1)和(flower,1)返回
      }
    }
    println(rddm)
    /*
    * 与map的对比，map进去2元素，输出两个元素，flatMap进去2个元素输出4个元素，因为后者会拆分集合，使之扁平化
    * */
    val list1: Seq[Array[(String, Int)]] = list.map {
      x => {
        val datas: Array[String] = x.split("_")
        val chips: Array[String] = datas(2).split(",")
        chips.map(x => (x, 1)) //此时x还是一个集合，所以它拆分成了(x,1)但没有扁平化，多个(x,1)还是在一个集合中
      }
    }
    println(list1)

  }
}