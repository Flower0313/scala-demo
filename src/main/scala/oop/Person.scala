package oop

import scala.beans.BeanProperty

/**
 * @ClassName ScalaDemo-Person 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日16:10 - 周五
 * @Describe
 */
class Person {
  var name: String = "bobo"

  var age: Int = _ //_表示给属性一个默认值,int默认值是0

  //添加这个标记后，默认能调用getSex和setSex,而不用自己重写
  @BeanProperty var sex: String = "male"

  //请注意常量val的属性不能赋默认值，必须显示指定
  val tall: Int = 176



  def showTall() = println("我很高")


}

object Test {
  def main(args: Array[String]): Unit = {
    var person = new Person()
    println(person.name)
    println(person.age)
    person.setSex("男")
    println(person.getSex)
    person.showTall()
  }
}


class Teacher {

}
