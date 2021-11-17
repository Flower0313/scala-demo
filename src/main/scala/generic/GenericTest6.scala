package generic

import scala.reflect.ClassTag

/**
 * @ClassName ScalaDemo-GenerocTest6 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日21:03 - 周四
 * @Describe T:ClassTag 和 T:Manifest
 */
object GenericTest6 {
  def main(args: Array[String]): Unit = {
    /**
     * Q: 可以创建泛型数组吗?
     *理论上是不可以的，因为没有指定具体的，在Scala程序运行中，数组必须有具体的类型，没有否无法创建的相应的数组
     *引出Manifest的概念可以创建泛型数组
     *[T : Manifest]这样的写法被称之为Manifest上下文界定  实质上这是需要一个Manifest[T]类型的隐式对象 这又是一个"隐式转换"的过程，有这样的一个隐式转换来辅助我们构建Manifest[T]来确定T的类型
     * 通过这个隐式的值来辅助构建泛型数组，来确定T的具体类型
     * 所以在创建泛型函数时 需要Manifest的类型来辅助构建泛型数组，借助Manifest类型对象来指定泛型数组具体的类型
     *
     * 通过Manifest[T]可以记录T的类型 在实际运行的时候我们获取T具体的类型
     * */
    def arrayMake[T : Manifest](first: T, second: T) = { //去掉: Manifest出错
      val r = new Array[T](2)
      r(0) = first
      r(1) = second
      r
    }
    arrayMake(1, 2).foreach(println)         //1 2


    /**
     * [T : ClassTag]这种写法说明：当这个函数在运行时,会保存传进来的参数类型直到运行时，防止类型被jvm擦除
         主要是在运行时指定，在编译时无法确定的type的信息
         编写编译的时候没有具体类型，运行的时候必须要有具体的类型，
    所以需要一种机制运行的时候会根据类型进行推断类型，classTag会帮我们存储这个类的信息，然后交给虚拟机
     */
    def mkArray[T : ClassTag](elems: T*) = Array[T](elems: _*)
    mkArray(42, 13).foreach(println)                //42  13
    mkArray("Japan", "Brazil", "Germany").foreach(println)          //"Japan", "Brazil", "Germany"

    val array: Array[Any] = mkArray(1, 2, "a")
    val array1:Array[Int] = mkArray(1,2,3)
    val strings: Array[String] = mkArray("a", "b", "c")

  }
}
