package func

/**
 * @ClassName ScalaDemo-functionT16 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月20日14:02 - 周三
 * @Describe 方法的具体省略步骤
 */
object functionT16 {
  def main(args: Array[String]): Unit = {
    /*
    * 1.完整版
    * 函数名：n_fun0
    * 传入类型: (x:Int)
    * 传出类型: Boolean
    * 函数体: ={ return x!=0 }
    * */
    def n_fun0(x: Int): Boolean = {
      return x != 0
    }

    //2.省略return
    def n_fun1(x: Int): Boolean = {
      x != 0
    }

    //3.只有一行代码：省略大括号
    def n_fun2(x: Int): Boolean = x != 0

    //4.省略返回值类型Boolean，系统根据你的逻辑自动判断返回值
    def n_fun3(x: Int) = x != 0


    /*
    * 5.n_fun3是一个方法，我们可以将它转换成函数func4
    * 函数名:func4
    * 函数类型: Int=>Boolean
    * 输入值: (x:Int)
    * 函数体: x!=0
    * */
    val func4: Int => Boolean = (x: Int) => {
      x != 0
    }
    //val func4_2: Int => Boolean = (x: Int) => x != 0
    //6.1因为你在输入值的时候声明了Int类型，而且返回值类型又会根据你的逻辑自动推断，所以函数类型可以省略
    val func5_1 = (x: Int) => x != 0
    def func5_1_2 = (x: Int) => x != 0

    //6.2也可以保留函数的类型，这样就可以省略x的输入类型了
    //因为 Int => Boolean 对应 x => x!=0
    val func5_2: (Int => Boolean) = (x) => x != 0
    //func5_2(3)

    //7.而6.2的写法能发展成参数用_代替
    val func6: Int => Boolean = _ != 0




  }
}
