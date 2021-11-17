package oop

/**
 * @ClassName ScalaDemo-Color 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日12:25 - 周日
 * @Describe 枚举和应用类
 */

//枚举类
object Color2 extends Enumeration {
  val RED = Value(1, "red")
  val BLUE = Value(2, "blue")
  var YELLOW = Value(3,"yellow")
}

//应用类
object Test14{
  def main(args: Array[String]): Unit = {
    //因为伴生对象相当于静态属性，所以可以直接用
    println(Color2.YELLOW)

    //相当于c中的typeof
    type S = String
    var v:S = "abc"
    def test():S="xyz"
  }
}

object TestApp extends App{
  //不用写main方法就能执行，因为App里面自带一个main方法
  println("app start")

}