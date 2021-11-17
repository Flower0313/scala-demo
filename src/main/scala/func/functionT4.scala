package func

/**
 * @ClassName ScalaDemo-functionT4 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日10:58 - 周四
 * @Describe 方法至简原则
 */
object functionT4 {
  def main(args: Array[String]): Unit = {
    //0.正常函数写法
    def f0(s: String): String = {
      return s + ",flower"
    }

    //1.return可以省略，scala会使用函数体的最后一行代码作为返回值
    def f1(s: String): String = {
      s + ",flower"
    }

    println(f1("xiaohua"))

    //2.如果函数体只有一行代码，可以省略花括号
    def f2(s: String): String = s + ",flower"

    println(f2("xiaohua2"))

    //3.返回值类型如果能推断出来，那么可以省略(:和返回值类型一起省略)
    def f3(s: String) = s + ",flower"

    println(f3("xiaohua3"))

    //4.如果有return，则不能省略返回值类型，必须指定
    def f4(): String = {
      return "flower"
    }

    println(f4()) //flower

    //5.如果函数明确声明Uint，那么函数体中使用return关键字也不起作用，因为Unit啥也不接收
    def f5(): Unit = {
      return "flower"
    }

    println(f5()) //()

    //6.scala如果期望是无返回值类型，可以省略等号和小括号；将无返回值的函数称为过程
    def f6  {
      "flower"
    }

    println(f6) //()

    //7.如果函数无参，但声明了参数列表，那么调用时，小括号可加可不加
    //这里相当于scala把最后一行代码当返回值，并推断返回值类型
    def f7() = "flower"

    println("f7" + f7()) //flower
    println(f7) //flower

    //8.如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    def f8 = "flower"

    println("f8=" + f8)
    //println(f8()) 会报错

    //9.如果不关心名称，只关系逻辑，那么函数名(def)可以省略，相当于匿名函数
    def f9(x: Int): Int = {
      x + 1
    }
    //当方法只有一个参数时，可以用f9{参数}替代f9(参数)
    f9{2}

    def f9_1(x: Int) = x + 1

    //匿名函数，lambda表达式,这个函数类型就是Int=>Int
    var f = (x: Int) => x + 1
    println("f:" + f(3))



    //以下两种方式等价
    def n_fun = (x: Int) => x == 0 //var n_fun: (Int => Boolean) = (x: Int) => x == 0是完整写法，省略了函数的类型，因为可以自动推断

    var n_fun2: Int => Boolean = (x: Int) => x != 0

    //不能直接这样,因为这样scala不会自动推断类型，一点根据都没有，这没有类型推断，所以不能省略Int
    //val ff = x => x + 1

    //定义一个空参的匿名函数
    var userDir = () => "eeeeeeee"
    println(userDir())

    //10.当不声明返回值类型的时候，连=号都可以省略，这种情况和java方法类似了
    def f10() {
      println("不带括号")
      println("第二行")
    }

    f10()

  }
}
