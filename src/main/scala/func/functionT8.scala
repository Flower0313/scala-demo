package func

import scala.reflect.internal.util.StringOps

/**
 * @ClassName ScalaDemo-functionT8 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日14:58 - 周四
 * @Describe 匿名函数的至简原则
 */
object functionT8 {
  def main(args: Array[String]): Unit = {
    //需求一
    //1.定义一个函数：参数包含数据和逻辑函数,t_op是函数，参数是Int，返回值也是Int，因为=>
    def operation(arr: Array[Int], t_op: Int => Int) = {
      //yield是将结果整合成一个集合
      for (elem <- arr) yield t_op(elem)
    }

    //2.定义逻辑函数,真实的函数
    def op(ele: Int): Int = {
      //相当于return ele+1
      ele + 1
    }

    //3.调用operation函数，参数一是集合，参数二是函数，然后t_op就具有了op的功能，在其operation内部使用t_op即可
    val arr = operation(Array(1, 2, 3, 4), op)
    //mkString原字符串使用特定的字符串seq分割
    println(arr.mkString(",")) //2,3,4,5
    println("flower".mkString(",")) //f,l,o,w,e,r

    //4.采用匿名函数,这里将op的功能写在了函数里面
    val arr1 = operation(Array(1, 2, 3, 4), (ele: Int) => {
      ele + 2
    })
    println(arr1.mkString(","))

    //4.1参数的类型可以省略，会自动推断
    val arr2 = operation(Array(1, 2, 3, 4), (ele) => {
      ele + 2
    })
    println(arr2.mkString(","))

    //4.2类型省略后，发现只有一个参数，则圆括号也能省略
    val arr3 = operation(Array(1, 2, 3, 4), ele => {
      ele + 2
    })
    println(arr3.mkString(","))

    //4.3匿名函数只有一行，则大括号也能省略
    val arr4 = operation(Array(1, 2, 3, 4), ele => ele + 1)
    println(arr4.mkString(","))

    //4.4如果参数只出现一次，则参数省略且后面参数可以用_代替,且参数要按照顺序
    //这里ele只出现了一次,当化简到只有一个下划线，会报错，因为和默认值重复
    //注意下划线不能嵌套到函数中，也就是不能嵌套双层函数,一个下划线只代表一个参数
    val arr5 = operation(Array(1, 2, 3, 4), _ + 1)
    println(arr5.mkString(","))

    //若省略了函数的(Int,Int)=>Int类型，则会报错,就没有类型推断了
    val arr6: (Int, Int) => Int = _ + _
    println("============:" + arr6(1, 2))

    /*------------------------------------------------------------------*/
    //需求二
    //定义了ca
    def calculator(a: Int, b: Int, op: (Int, Int) => Int): Int = {
      op(a, b)
    }

    //1.标准版
    println(calculator(2, 3, (x: Int, y: Int) => {
      x + y
    }))

    //2.只有一行，则省略大括号
    println(calculator(2, 3, (x: Int, y: Int) => x + y))

    //3.参数的类型可以省略,会根据op中类型推断
    println(calculator(2, 3, (x, y) => x + y))

    //4.如果参数只出现一次，则参数省略且后面可以用_代替
    println(calculator(2, 3, _ + _))

    //特殊情况，若传入的参数顺序和计算顺序相反呢，比如(a,b) => b - a
    println(calculator(2, 3, -_ + _))


    /*--------------------------------------------------------------*/

    //需求三:数据已经定义好了atguigu，但传入的函数需要做什么逻辑操作看你自己
    def f(func: String => Unit): Unit = {
      func("atguigu")
    }
    //正常匿名函数，描述了将atguigu传入进来后要做的事情
    f((name: String) => {
      println(name)
    })
    //省略1
    f(name => println(name))

    //省略2:只有一个参数可以使用_来代替
    f(println(_))

    //省略3：如果可以推断出，当前传入的println是一个函数体，而不是调用语句
    //可以直接省略下划线
    f(println)

    /*--------------------------------------------------------------------*/
    //练习1
    /*
    * ：定义一个匿名函数，并将它作为值赋给变量 fun。函数有三个参数，类型分别
        为 Int，String，Char，返回值类型为 Boolean。
        要求调用函数 fun(0, “”, ‘0’)得到返回值为 false，其它情况均返回 true。

    * */
    //匿名函数
    var fun = (x: Int, y: String, z: Char) => {
      if (x == 0 && y == "" && z == '0') {
        true
      } else {
        false
      }
    }
    println(fun(0, "", '0'))
    //简化成匿名函数后
    var n_fun: (Int, String, Char) => Boolean = (x: Int, y: String, z: Char) => (x == 0 && y == "" && z == '0')
    var n_fun1 = (x: Int, y: String, z: Char) => (x == 0 && y == "" && z == '0')
    //去掉返回值类型，系统会自动推断
    var n_fun2: (Int, String, Char) => Boolean = (_ == 0 && _ == "" && _ == '0')


    println("n_fun:" + n_fun(0, "", '0'))
    println("n_fun2:" + n_fun2(0, "", '0'))

    //练习2
    /*
    *  定义一个函数 func，它接收一个 Int 类型的参数，返回一个函数（记作 f1）。
       它返回的函数 f1，接收一个 String 类型的参数，同样返回一个函数（记作 f2）。函数 f2 接
       收一个 Char 类型的参数，返回一个 Boolean 的值。
       要求调用函数 func(0) (“”) (‘0’)得到返回值为 false，其它情况均返回 true。
    * */
    //普通函数
    //func2接收一个返回值类型为f1的函数，那么f1的是什么类型的函数呢？是String=>(Char=>Boolean)类型的
    def func2(x: Int): String => (Char => Boolean) = {
      //这里为什么:后面是Char => Boolean，因为它f1接收的是f2，那么f2是一个Char=>Boolean类型函数，所以这个返回值类型也是这个
      def f1(y: String): Char => Boolean = {
        def f2(z: Char): Boolean = { //这里输入是Char类型，输出是Boolean类型，所以这是个Char=>Boolean类型的函数
          if (x == 0 && y == "" && z == '0') {
            false
          } else {
            true
          }
        }
        //相当于return 一个函数，上面声明了传入类型和返回值类型后就可以省略_了
        f2
      }
      //调用func2后将f1 _返回出去给它继续调用
      f1
    }


    //调用func2后返回的是一个f1函数，所以可以再次调用，调用完f1函数后返回的又是f2函数，又可以调用
    println(func2(0)("")('0'))

    //匿名函数，层层嵌套，为何这里可以省略呢？因为普通函数中的def并不属于实现部分，其实实现部分也就一行所以可以省略
    //为什么这里不能省略类型呢？因为这个匿名函数完全是自己声明的不像上面的calculator里面规定了函数的类型
    val n_fun11: (Int => String => Char => Boolean) = (x: Int) => (y: String) => (z: Char) => !(x == 0 && y == "" && z == '0')
    println("n_fun11:" + n_fun11(0)("")('0'))
    //将n_fun1也可以变成匿名函数

    //简化步骤一
    def func3(x: Int): String => (Char => Boolean) = {
      def f1(y: String): Char => Boolean = { //f1输入为String类型，返回一个Char=>Boolean的函数类型
        //省略方式就是去除def f2名字，留下输入类型(z:Char) => ...
        (z: Char) => !(x == 0 && y == "" && z == '0') //写成Char=>Boolean的函数类型
      }

      f1
    }

    //简化步骤二:给z添加输入类型，然后f1的返回类型就可以自动推断出了
    def func4(x: Int): String => (Char => Boolean) = {
      def f1(y: String) = { //f1需要返回一个Char=>Boolean的函数类型
        (z: Char) => !(x == 0 && y == "" && z == '0') //写成Char=>Boolean的函数类型
      }

      f1
    }

    //简化步骤三:简化f1,根据func5的返回类型来写
    def func5(x: Int): String => (Char => Boolean) = {
      y => (z: Char) => !(x == 0 && y == "" && z == '0') //写成String=>()
    }

    //简化步骤四：给y加上类型，然后就可以去掉func5的返回值类型了，因为会自动推断,然后去掉括号
    def func6(x: Int) =
      (y: String) => (z: Char) => !(x == 0 && y == "" && z == '0') //写成String=>()

    //将func6也写为匿名函数
    val func6_2 = (x: Int) =>(y: String) => (z: Char) => !(x == 0 && y == "" && z == '0')

    //简化步骤五，将def func6也写成匿名函数，然后将z用_线替代
    val func7: Int => (String => (Char => Boolean)) =
          x => y => x != 0 || y != "" || _ != '0'
  }
}
