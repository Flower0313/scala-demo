package mat

/**
 * @ClassName ScalaDemo-MatchTest8 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日23:07 - 周一
 * @Describe 匹配对象1
 */
object MatchTest8 {
  def main(args: Array[String]): Unit = {

    val zhangsan = new Student("zhangsan", 18)

    //由于case后面不能写new，所以只能采取伴生对象的apply来使new消除。
    zhangsan match {
      case Student("zhangsan", 18) => println("找到张三啦")
      case _ => println("你不是zhangsan")
    }

  }
}

class Student(val name: String, var age: Int)

object Student {
  // 创建对象的方法
  def apply(name: String, age: Int): Student = new Student(name, age)

  // 解析对象的方法，这是必须实现的方法，因为case要拆开进行比对地址
  def unapply(arg: Student): Option[(String, Int)] = {
    // 如果解析的参数为null
    if (arg == null) None else Some((arg.name, arg.age))
  }
}

