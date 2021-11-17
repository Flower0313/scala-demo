package c1

/**
 * @ClassName ScalaDemo-HelloWorld 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日10:25 - 周四
 * @Describe
 */


//声明了一个单例对象
object HelloWorld {
  val name: String = "flower"
  println("hah")

  //main 方法：从外部也是可以直接调用执行的方法
  //def 方法名称（参数名称：参数类型）：返回值类型
  //可以省略分号（可加可不加）
  def main(args: Array[String]): Unit = {
    println(name)
    //System.out.println("hello i'am java")
  }
}
