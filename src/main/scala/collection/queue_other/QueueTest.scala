package collection.queue_other

import scala.collection.mutable

/**
 * @ClassName ScalaDemo-QueueTest 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日21:16 - 周一
 * @Describe 队列 - 先进先出
 */
object QueueTest {
  def main(args: Array[String]): Unit = {
    val que = new mutable.Queue[String]()

    que.enqueue("a","b","c")
    
    println(que)//Queue(a, b, c)
    que.foreach(print)//abc
    println("----")
    println(que.dequeue())
    println(que.dequeue())
    println(que.dequeue())
  }
}
