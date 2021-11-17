package oop

/**
 * @ClassName ScalaDemo-Person4 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日19:49 - 周五
 * @Describe 构造器参数
 */

//若在主构造器中形参加上val和var就可以直接作为属性调用，若不带的话还需要在类中定义变量去接收
class Person4(name: String, var age: Int, val sex: String) {
  //将局部变量赋值给成员变量
  var nickname:String = name;
}

object Test2{
  def main(args: Array[String]): Unit = {
    var person = new Person4("flower", 18, "male")

    //1.未用任何修饰符修饰，这个参数就是一个局部变量,调用失败
    //printf(person.name)
    println(person.nickname)

    //2.var修饰参数，作为类的成员属性使用，可以修改
    person.age = 19
    println(person.age)

    //3.val修饰参数，作为类的成员属性使用，不能修改
    //person.sex="女"
    println(person.sex)
  }
}
