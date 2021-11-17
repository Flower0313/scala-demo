package func

/**
 * @ClassName ScalaDemo-functionT10 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日21:10 - 周四
 * @Describe 闭包 and 柯里化
 */
object functionT10 {
  def main(args: Array[String]): Unit = {
    def add1(a: Int, b: Int): Int = {
      a + b
    }

    //1.考虑固定一加数的场景
    def addByFour1(b: Int) = {
      4 + b
    }

    //2.扩展固定加数改变的情况
    def addByFive1(b: Int) = {
      5 + b
    }

    //3.将固定加数作为另一个参数传入，但是是作为”第一层参数“传入
    //add()()
    def addByFour2: Int => Int = {
      val a = 4

      def addB(b: Int) = {
        a + b
      }
      //为什么这里不用加_?
      //因为你在addByFour2声明了返回值类型是Int=>Int,就不用_将方法转为函数了
      addB
    }

    println("---------------------------------------------------------------------")

    //因为首先addByA压入栈，再addByB,这个过程中a的值是一直在的
    def addByA(a: Int) = {
      //a进来后并不会执行这个方法，需要返回一个addByB去接收b
      def addByB(b: Int) = {
        a + b
      }
      //方法不能直接作为值来传递，所以将它转化为函数值
      //这里没显式声明Int=>Int，就需要_来将方法变成函数值(Int=>Int)
      addByB _
    }

    println("---------------------------------------------------------------------")

    //简化
    def addByA2(a: Int): Int => Int = {
      //将addByB方法函数化了
      //b接收到的是int类型，而addByA2接收到的你Int=>Int类型（b=>a+b）
      //为啥b的类型也可以省略呢？因为在addByA2的返回值类型中已经定义好了
      b => a + b
      //a + _
    }

    println("---------------------------------------------------------------------")

    //极简化,接收到一个int类型的a，然后返回值类型是Int=>Int函数型，具体实现是a + _
    def addByA3(a: Int): Int => Int = a + _




    //4.lambda化,(a:Int)收到的返回值类型是(b:Int)=>a+b,而(b:Int)收到的返回值类型是a+b的int类型
    var n_addByA = (a: Int) => ((b: Int) => a + b)



    println(addByA(35)(24))
    println(addByA3(3)(2))
    println(n_addByA(13)(3))

    //5.柯里化，将多个参数合成一个参数列表，底层是闭包实现的(就是我们上面的写法)
    def addCurrying(a: Int)(b: Int): Int = {
      a + b
    }

    println(addCurrying(13)(3))


  }
}
