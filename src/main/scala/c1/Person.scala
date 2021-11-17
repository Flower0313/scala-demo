package c1

/**
 * @ClassName ScalaDemo-Person 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月28日1:01 - 周四
 * @Describe
 */
class XIAO(age: Int) {

  def show() = {
    println("肖华")
  }

  //这种写法相当于java中的在XIAO的构造函数中调用show()

  show() //会加载show()
}


object test {
  def main(args: Array[String]): Unit = {
    val person: XIAO = new XIAO(313)
  }
}
