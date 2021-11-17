package generic

/**
 * @ClassName ScalaDemo-GenericTest2 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日14:45 - 周二
 * @Describe 泛型上下限定
 */
object GenericTest2 {
  def main(args: Array[String]): Unit = {
    test1[SubChild](classOf[SubChild])
    test2[Parent](classOf[Parent])
    test3[Parent](new Parent())
    //test2(classOf[SubChild])运行的时候会报错
  }

  //泛型通配符之上限
  def test1[A <: Child](a: Class[A]) = {
    println(a)
  }

  //泛型通配符之下限
  def test2[A >: Child](a: Class[A]) = {
    println(a)
  }

  //泛型通配符之下限，形式扩展
  def test3[A >: Child](a: A) = {
    println(a)
  }

}


class Parent

class Child extends Parent

class SubChild extends Child

