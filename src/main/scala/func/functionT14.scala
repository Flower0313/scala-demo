package func

/**
 * @ClassName ScalaDemo-functionT14 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日21:17 - 周二
 * @Describe 柯里化进阶
 */
object functionT14 {
  //方式一：普通写法
  def merge1(s1: String, s2: String): String = s1 + s2


  //方式二：柯里化,其中f1是函数要做的就是将两个字符串转换成一个字符串
  def merge4(s1: String, s2: String)(f1: (String, String) => String): String = f1(s1, s2)

  //柯里化写法的原理，其实就是这样组装的
  def merge2(s1: String): String => String = {
    def merge3(s2: String): String = {
      s1 + s2
    }

    merge3
  }



  def main(args: Array[String]): Unit = {
    //不够灵活,若要修改其中一个值再拼接，那么要改源码,比如s1变成大写再拼接
    val str1 = merge1("abc", "xyz")
    println("str1:" + str1)

    val str2 = merge2("abd")("xyz")
    println("str2:" + str2)

    val str3 = merge4("abc", "xyz")((x, y) => x + y)
    //val str3 = merge4("abc", "xyz")(_ + _)
    println(str3)

    //当需求变化时
    val str4 = merge4("abc", "xyz")(_.toUpperCase() + _)
    println(str4)
  }
}
