package mat

/**
 * @ClassName ScalaDemo-MatchTest9 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月18日23:36 - 周一
 * @Describe 匹配样例类
 */
object MatchTest9 {
  def main(args: Array[String]): Unit = {
    val hubo = new Teacher("hubo", 36)

    hubo match {
      case Teacher("hubo",36) => println("找到胡波啦")
      case _ => println("没找到")
    }
  }
}

//自动生成伴生对象和unapply
case class Teacher(name: String,age: Int)