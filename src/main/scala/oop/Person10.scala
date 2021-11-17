package oop

/**
 * @ClassName ScalaDemo-Person10 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日23:58 - 周五
 * @Describe 单例模式
 */

class Person10 private(val name: String, val age: Int) {
  def printInfo() {
    println(s"姓名:${name},年龄:${age}")
  }
}

//饿汉式
/*object Person10 {
  private var p1 = new Person10("flower", 18)
  def getInstance() = p1
}*/

//懒汉式
object Person10 {
  private var p1: Person10 = _
  def getInstance(): Person10 = {
    //必须要加判断，不然p1和p2不是同一个对象，这就不是单例模式了
    if(p1 == null){
      p1 = new Person10("flower", 18)
    }
    p1
  }

}


object Test8 {
  def main(args: Array[String]): Unit = {
    var person1 = Person10.getInstance()
    //main方法还没结束，所以Person10一直活着，静态对象的生命周期和类一样，所以也活着
    person1.printInfo()
    var person2 = Person10.getInstance()
    person2.printInfo()
    //可以看到person1和person2打印的地址是一样的,所以单例对象全局只有一份
    println("person1:" + person1 + "\nperson2:" + person2)
  }
}
