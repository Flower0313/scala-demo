package func

import scala.language.implicitConversions

/**
 * @ClassName ScalaDemo-functionT17 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日19:22 - 周三
 * @Describe 偏函数 - 所谓偏函数就是用{}包含起来的多种case语句
 */
object functionT17_1 {
  def main(args: Array[String]): Unit = {
    //1.定义偏函数(可以调用)
    val pf: PartialFunction[Int, String] = {
      case 1 => "一"
      case 2 => "二"
      case 3 => "三"
      case _ => "未匹配"
    }

    //2.调用偏函数
    println(pf(1))
    println(pf(2))
    println(pf(3))

  }
}

object functionT17_2 {
  def main(args: Array[String]): Unit = {
    val list = (1 to 10).toList

    //核心:偏函数 结合 集合的函数式编程来使用
    val list2 = list.map {
      case x if x >= 1 && x <= 3 => "[1-3]"
      case x if x >= 4 && x <= 8 => "[4-8]"
      case _ => "(8-*]"
    }
    println(list2)
  }
}

object functionT17_3 {
  def main(args: Array[String]): Unit = {
    //1.定义集合,xx to xx底层就是Vector集合
    val t1 = (1 to 10).toTraversable

    val t2 = Traversable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) //底层是List

    //2.通过collect方法筛选出集合中所有的偶数

    //方式一：分解版
    val pf: PartialFunction[Int, Int] = {
      //x表示集合中的每一个数字,x是奇数就不操作，x是偶数就输出x
      case x if x % 2 == 0 => x
    }
    val t3 = t1.collect(pf)
    println(t3)

    //方式二：合并版
    val t4 = t2.collect({
      case x if x % 2 == 0 => x
    })
    println(t4)

  }
}

object functionT17_4 {
  def main(args: Array[String]): Unit = {
    val list = List(("a", 12), ("b", 13), ("c", 20))

    //需求：key不变，value*2
    //方法一:map
    val tuples = list.map(k => (k._1, k._2 * 2))
    println(tuples)

    //方法二:偏函数模式匹配,map分解的元素是以一个元组为单位的,所以要match元组的格式(k,v),{ }就是代码块
    //完整版
    list.map({
      t => {
        t match {
          case (k, v) => (k, v * 2)
        }
      }
    })

    //省略一版(map加代码块)
    //偏函数的背后是PartitionFunction[A,B]继承于function[A,B]所以能传入map当匿名函数使用
    //一个case语句就是一个独立的匿名函数
    val tuples1 = list.map({
      case (k, v) => (k, v * 2)
    })

    //省略二版(偏函数)，因为{ }内是一个整体，相当于()中只有一个参数，那就省略小括号
    val tuples2 = list.map {
      case (k, v) => (k, v * 2)
    }
    //下面调用方法的方法等价
    functionT17_5.show(313)
    functionT17_5 show (33)
  }
}

object functionT17_5 {
  def show(a: Int): Int = a + 1

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)


    //方法可以直接用代码块调用，因为代码块就是一个函数，返回最后一行值
    val unit = show {
      313
    } //等价于show(313)


    //所以下面也是可用的
    val list1 = list.map { x => x + 1 } //等价于map(x=>x+1)

    List(1, 3, 5, "seven").collect { case i: Int => i + 1 }

  }
}

object functionT17_6 {
  def main(args: Array[String]): Unit = {
    //需求对集合中所有数字加1，忽略调非数字的元素

    val list: List[Any] = List(1, 2, 3, "abc")

    //1.模式匹配的结果,List(2, 3, 4, ()),有瑕疵
    val list1: List[Any] = list.map {
      case x: Int => x + 1
      case _ =>
    }

    //2.偏函数List(2, 3, 4)
    //定义偏函数,传入类型是Any，返回类型是Int
    val partFun: PartialFunction[Any, Int] = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = {
        //遍历list所有元素，判断进来的元素是不是Int类型,返回为true则走apply方法，false则不执行
        x.isInstanceOf[Int] //执行4次
      }

      override def apply(v1: Any): Int = {
        //对经过了判断的值+1然后放入到新集合
        v1.asInstanceOf[Int] + 1 //执行3次
      }
    }
    val res: List[Int] = list.collect(partFun)

    implicit def DoubleToInt(x: Double) = x.toInt

    //3.偏函数的简化形式
    def partFun2: PartialFunction[Any, Int] = {
      case i: Int => i + 1
      case i: Double => i * 2
    }

    val ints: List[Int] = list.collect(partFun2)

    //4.更简化的形式
    val ints1: List[Int] = list.collect { case i: Int => i + 1 }

    println(ints1)

  }
}
























