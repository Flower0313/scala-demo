package implic

/**
 * @ClassName ScalaDemo-ImplicitTest3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日20:30 - 周二
 * @Describe 隐式参数--手动/自动导入
 */
object ImplicitTest3 {
  //定义show方法，实现将传入的值，使用指定的分隔符和后缀包裹起来

  //show方法需要接收一个姓名，再接收一个指定的前缀、后缀信息的隐式参数，然后按照指定的格式拼接
  //f_delimit定义为一个元组
  //f_delimit如果不给值的话，它会默认寻找场上为(String,String)类型的隐式参数
  def show(name: String)(implicit f_delimit: (String, String)):String =
    f_delimit._1 + name + f_delimit._2

  //object ImplicitParam {
    //隐式值，用来给隐式参数赋值的
    implicit val delimit_flower1 = ("<<<", ">>>")
    //implicit val delimit_flower2 = "<<<" -> ">>>"
  //}

  def main(args: Array[String]): Unit = {
    //import ImplicitParam.delimit_flower1

    //如果你赋值了就按你的值来走，如果没给值，就走隐式参数
    println(show("张三")) //<<<张三>>>
    println(show("李四")("((", "))"))//((李四))
  }
}
