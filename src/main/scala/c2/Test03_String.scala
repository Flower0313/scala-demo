package c2

/**
 * @ClassName ScalaDemo-Test03_Comment 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日15:43 - 周四
 * @Describe
 */
object Test03_String {
  def main(args: Array[String]): Unit = {
    var name = "holden"
    var age = 22
    val num: Double = 3.14159

    //多行字符串，保持多行字符串原格式输出
    val s =
      s"""
         |select
         |   name,
         |   age
         |from user
         |where name = '$name' and age = '${age + 2}'
         |""".stripMargin

    println(name + "\t" + age + "\n")
    //%s和%d都是占位符
    printf("name=%s,age=%d\n", name, age)
    println(s"name=$name,age=${age + 10}")
    //整个数长3，不够补空格，只保留2位小数, 3.14
    println(f"The num is ${num}%3.2f")
    //不会解析格式，只会解析变量，填写什么输出什么, 3.14159%3.2f
    println(raw"The num is ${num}%3.2f")
    println(s)
    //将flower打印10次
    println("hello" + ("flower ") * 10)

    //前面必须要加s才能替换name
    val s2 = s"name=$name"
    println(s2)
  }
}
