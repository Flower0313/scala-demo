package func

import scala.annotation.tailrec

/**
 * @ClassName ScalaDemo-functionT11 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日23:28 - 周四
 * @Describe 递归函数
 */
object functionT11 {

  def fact(i: Int): Int = {
    //这里不能省略return，因为省略只返回最后一行
    //会给计算机带来负担，层层叠加栈帧溢出
    //为什么会导致层层叠加栈帧呢？
    //因为你return fact(i-1)*i,你的i还在这个栈里，你的fact()就计算下一个栈了，
    //所以i会在第一个栈等后续fact()完成后的结果完成再一起计算
    if (i == 1) return 1
    fact(i - 1) * i
  }

  //尾递归调用,res是存储当前计算结果的
  @tailrec //加上这个注解能检查此尾递归方法是否有误
  def tailFact(n: Int, res: Int): Int = {
    if (n == 0) return res
    //这里就一起调用tailFact(),就没有像上面那样还有变量在等你完成了
    //使用一个栈后就释放了然后接着使用下一个栈帧，就不会出现层层叠加的状况
    tailFact(n - 1, n * res)
  }

  def main(args: Array[String]): Unit = {
    // 阶乘
    println(fact(5))
    println(tailFact(5, 1))


  }
}
