package func

/**
 * @ClassName ScalaDemo-functionT5 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日11:49 - 周四
 * @Describe 函数可以作为值进行传递
 */
object functionT5 {
  def main(args: Array[String]): Unit = {
    def foo(): Int = {
      //println("foo...")
      313 //返回313
    }

    val f1 = foo
    println(f1) //返回值给f1，也就是313给f1
    println("================")

    val f2 = foo _ //相当于将foo方法转换成了函数给f2，有点像c的函数指针
    val tmp = f2() //单独输出f2是显示一个函数，所以必须要用输出函数的方法才行f2()
    println(tmp)
    println("================")

    val f3: () => Int = foo //因为313返回值时Int，所以这样写等价于f2那种
    println(f3())
  }

}
