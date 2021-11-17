package func

/**
 * @ClassName ScalaDemo-functionT2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日10:17 - 周四
 * @Describe
 */
object functionT2 {
  def main(args: Array[String]): Unit = {
    // 函数 1：无参，无返回值
    def test1(): Unit = {
      println("无参，无返回值")
    }
    test1()

    // 函数 2：无参，有返回值
    def test2(): String = {
      return "无参，有返回值"
    }
    println(test2())

    // 函数 3：有参，无返回值
    def test3(s: String): Unit = {
      println(s)
    }
    test3("jinlian")

    // 函数 4：有参，有返回值
    def test4(s: String): String = {
      return s + "有参，有返回值"
    }
    println(test4("hello "))

    // 函数 5：多参，无返回值
    def test5(name: String, age: Int): Unit = {
      println(s"$name, $age")
    }
    test5("dalang", 40)

    // 函数 6：多参，有返回值
    def test6(name: String, age: Int): Boolean = {
      println(s"$name,$age")
      return true
    }
    println(test6("xiaohua", 11))

  }

}
