package generic

/**
 * @ClassName ScalaDemo-GenericTest5 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月21日9:29 - 周四
 * @Describe 泛型方法
 */
object GenericTest5 {
  //需求一：定义getMiddleElement()来获取任意类型数组的中间元素
  def getMiddleElement(arr: Array[Int]) = {
    arr(arr.length / 2)
  }

  //方法名后面的T就是Array[T]中的元素类型
  def getMiddleElement2[T](arr: Array[T]) = {
    arr(arr.length / 2)
  }

  def demo[T](arr: Array[T]) = println(arr)

  def demo2[T <: Person13](arr: Array[T]) = println(arr)

  //限定下界
  def demo3[T >: Student13](arr: Array[T]) = println(arr)

  //既限定下界又限定上界
  def demo4[T >: PoliceMan <: Person13](arr: Array[T]) = println(arr)

  def main(args: Array[String]): Unit = {
    //println(getMiddleElement(Array(1, 2, 3, 4, 5)))
    //println(getMiddleElement(Array("a","b","c")))会报错，因为你定义接收Array[Int]
    println(getMiddleElement2(Array(1, 2, 3, 4, 5)))
    println(getMiddleElement2(Array("a", "b", "c")))

    demo(Array(new Student13, new Person13))

    demo2(Array(new Student13, new Person13))
    //demo2(Array(1, 2, 3)) 会报错

    //demo4(Array(new Superman))会报错


  }
}

class Person13

class Student13 extends Person13

class PoliceMan extends Person13

class Superman extends PoliceMan


