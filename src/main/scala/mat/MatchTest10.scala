package mat

/**
 * @ClassName ScalaDemo-MatchTest10 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月25日13:45 - 周一
 * @Describe 匹配对象2
 */
object MatchTest10 {
  def main(args: Array[String]): Unit = {
    //1.样例类型后的小括号中，编写的字段个数要和该样例类的字段个数保持一致
    //2.通过match进行模式匹配的时候，要匹配的对象必须声明为:Any

    val customer: Any = Customer("flower", 23)

    customer match {
      //保持字段个数一致就行
      case Customer(a, b) => println("Customer对象：" + a + "," + b)
      case Order(a) => println("Order对象：" + a)
      case _ => println("为匹配")
    }


  }
}

case class Customer(name: String, age: Int)

case class Order(id: Int)