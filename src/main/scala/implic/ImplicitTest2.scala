package implic

import java.io.File
import scala.io.Source

/**
 * @ClassName ScalaDemo-ImplicitTest2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日20:21 - 周二
 * @Describe 隐式方法--手动/自动导入
 */
object ImplicitTest2 {
  //1.定义RichFile类，来丰富file的功能
  class RichFile(file: File) {
    val name: String = "rich file"

    //2.定义read()方法
    def read() = Source.fromFile(file).mkString
  }

  object ImplicitDemo {
    //定义单例对象ImplicitDemo，隐式转换方法,加了这个后read()就能用了
    implicit def file2RichFile(file: File) = new RichFile(file)
  }


  def main(args: Array[String]): Unit = {
    //3.手动导入,若将ImplicitDemo去掉就能自动导入了
    import ImplicitDemo.file2RichFile

    //4.创建普通的File对象，尝试调用其read()功能
    val file = new File("T:\\ShangGuiGu\\ScalaDemo\\src\\main\\resources\\1.txt")

    //5.打印结果，本来file是没有read，转换成RichFile就有了
    println(file.read())
    //6.file也拥有的RichFile的属性
    println(file.name)

  }
}
