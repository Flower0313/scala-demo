package func

/**
 * @ClassName ScalaDemo-OtherTest 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日11:41 - 周三
 * @Describe 代码块的说明
 */
object functionT15 {
  def main(args: Array[String]): Unit = {
    {
      //这个代码块在java编译中和普通的println()没有区别，都是在main中执行，你可以查看编译文件
      println("我是代码块输出")
    }

    def hello(name: =>String)={
      name
    }

    //如果此时不用代码块就会出错，因为这里填了两个String，正常hello()只需填写一个参数
    /*hello(
      "牛逼"
      "哈哈"
    )*/

    //而用代码块就不会出错，因为代码块只返回最后一个行，所以不管你写多少行，都只返回一行，也就是一个参数
    hello({
      "牛逼"
      "哈哈"
    })

    //这样写，只会返回代码块中最后一行的代码
    val name:String = {
      "flower"
      "肖华"
    }
    val age:Int = 12
    
    println(s"name:${name},age:${age}")

    //结论:代码块能替代任何值，只不过只返回最后一行值而已，其余没有任何区别，你也向需要传值的方法中传入一段代码块，
    //且这个代码块最后一行是该方法需要的值即可
  }

}
