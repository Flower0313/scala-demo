package func

/**
 * @ClassName ScalaDemo-functionT12 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日0:06 - 周五
 * @Describe 控制抽象
 */
object functionT12 {
  def main(args: Array[String]): Unit = {
    //1.常规传值参数
    def f0(a: Int) = {
      println("a=" + a)
    }
    //f0(23)

    //2.值调用，返回一个23
    def f1(): Int = {
      //println("f1调用")
      23
    }

    //f0(f1())
    /*f0({
      println("我是代码块")
      313
    })*/

    //3.名调用(传代码)
    //=>Int表示一段代码块，且代码块的返回值是int类型（最后一行）
    def f2(a: => Int):String = {
      println("开始运行")
      //这里a要接收一个int值，所以你的代码块返回值必须是int
      println("a=" + a)
      println("a=" + a)
      "ok"
    }

    f2(f1())

    //3.2名调用,=>表示一个返回值是String的代码块
    //这里相当于将name变成了sayHi中的代码块
    def sayHi(name: =>String):String={
      println("sayHi调用")
      s"hi $name" //调用代码块
      s"hi $name" //调用代码块，因为代码块返回的是xiaohua，所以name=xiaohua，sayHi就将最后一行return出去
    }
    val name1:String = sayHi({ //sayHi中传入的代码块的返回值必须是String，这里返回的是xiaohua
      println("我是代码块")
      "xiaohua"
    })
    //println(name1)
    /*
    * sayHi调用
      我是代码块
      我是代码块
      hi xiaohua
    * */



    /*
    * f1调用
    * a=23
    * f1调用
    * a=23
    *
    * Q:为什么执行两次了，明明只调用了一次？
    * A:因为你将f1()传给了a而不是结果，那么a就相当于变成了函数，f2中a调用了两次，所以输出2次
    * */

    f2({
      println("这是一个代码块")
      313
    })

    //自定义while循环
    var i: Int = 1
    //这里是传了两个参数代码块
    myWhile(i <= 10) ({
      println(i)
      i += 1
    })

    //这里参数一不能写(condition:Boolean),因为这样是值传递，传递的是一个true，我们要传递的是i<=10才行
    //这样i不断+1才能增加到10，不然一直传一个true就是死循环
    def myWhile(condition: => Boolean)(op: => Unit): Unit = {
      println(condition)
      //这个condition是Boolean类型的
      if (condition) {
        //执行op，打印出当前数，并给i+1
        op
        myWhile(condition)(op)
      }
    }
  }
}
