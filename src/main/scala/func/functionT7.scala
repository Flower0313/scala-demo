package func

/**
 * @ClassName ScalaDemo-functionT7 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日14:07 - 周四
 * @Describe 函数可以作为函数返回值返回
 */
object functionT7 {
  def main(args: Array[String]): Unit = {
    //这里自动推断返回值类型，你啥都没return那肯定推断为Unit
    def f1() = {
      //f1中最后ren
      def f2(x:Int) = {
        //f2中啥都没干
      }

      f2 _ //在f1中相当于return f2 _
    }

    val f = f1() //返回的是f2 _ 所以导致f也变成了一个函数
    println(f(2))

    // 或
    println(f1()(2))
  }
}
