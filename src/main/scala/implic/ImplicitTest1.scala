package implic

/**
 * @ClassName ScalaDemo-ImplicitTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日0:12 - 周二
 * @Describe 隐式
 */
object ImplicitTest1 {


  def main(args: Array[String]): Unit = {
    val new12 = new MyRichInt(12)
    println(new12.myMax(15))

    //1.隐式函数
    //定义了一个隐式函数将数值转换成new MyRichInt(num),这是为啥能找到呢？因为根据类型
    //因为scala没编译性异常，所以这算是补偿了
    implicit def holden_Int(num: Int): MyRichInt = new MyRichInt(num)

    implicit def holden_String(str: String): MyRichInt = new MyRichInt(str.toInt)
    //很明显如果不加隐式函数，光一个数字是无法调用myMax方法的，
    //首先它会寻找哪些类有myMax，找到了MyRichInt有，那么找有没有隐式函数能将22转换成MyRichInt
    //根据22的Int类型寻在，找到了一个holden_Int,而它正好需要Int类型的参数，那么就用它转换
    println(22.myMax(10))//相当于holden_Int(22)
    println("313".myMax(32))

    //2.隐式类
    //不能是最顶级的，也就是只能定义在object里面,意思是不能和最外层的object平级

    implicit class MyRichInt2(val self: Int) {
      //自定义比较大小
      def myMax2(i: Int): Int = {
        if (self < i) i else self
      }

      def myMin2(i: Int): Int = {
        if (self < i) self else i
      }
    }
    //隐式类会自动处理,就不用再写隐式方法来转换了
    println(22.myMax2(22))

    //3.隐式参数
    //这里的str和name名字都不同，这里找隐式参数是根据类型来找的，而不是名字
    //所以在同一作用范围内，相同类型的隐式参数只能有一个
    implicit val str: String = "flower"
    implicit val num: Int = 18

    def sayHello(implicit name: String): Unit = {
      println("hello!" + name)
    }
    //这样就算不传值也不会报错
    //为什么省略小括号呢，因为底层就是柯里化，改成sayHello()(implicit name:String)
    //后调用的时候就也能加小括号了
    sayHello
    sayHello("holdxiao")
    //sayHello()

    //4.隐式参数简便写法
    def hiAge(name: String) = {
      //用implicitly[类型]指明想要拿到Int类型的隐式参数,因为不是根据名字找，而是根据参数类型
      println(s"hi!${name}" + implicitly[Int])
    }

    hiAge("xiaohua") //这里没有传年龄
  }
}


//在前面加implicit会报错
class MyRichInt(val self: Int) {
  //自定义比较大小
  def myMax(i: Int): Int = {
    if (self < i) i else self
  }

  def myMin(i: Int): Int = {
    if (self < i) self else i
  }
}
