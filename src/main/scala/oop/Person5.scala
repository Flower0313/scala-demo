package oop


/**
 * @ClassName ScalaDemo-Person5 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月15日20:08 - 周五
 * @Describe 继承
 */
//5.跳到了Person5主构造器中
class Person5(nameParam: String) {
  println(s"4.name=${name},age=${age}")
  var name = nameParam
  var age: Int = _
  println(s"5.name=${name},age=${age}")

  def this(nameParam: String, ageParam: Int) {
    //4.跳到了Person5的辅助构造器中，下面是调用其Person5的主构造器
    this(nameParam)
    this.age = ageParam
    //7.执行完了Person5的主构造器，然后执行此println
    println(s"7.name=${name},age=${age}")
    println("父类辅助构造器")
  }
  //6.执行完主构造器，输出此println
  println("父类主构造器")

  def hiPeople=println("hi!Person")
}

//3.跳到了Emp主构造器，由于他extends Person5()的辅助构造器，就跳到父类的2个参数辅助器中
//这里在java中相当于super(name,age)，由子类将值传给父类
class Emp(nameParam: String, ageParam: Int) extends Person5(nameParam, ageParam) {
  var empNo: Int = _
  println(s"8.name=${name},age=${age},empNo=${empNo}")


  def this(nameParam: String, ageParam: Int, empNoParam: Int) {
    //2.跳到了这里，然后又被下面这个语句送到Emp的主构造器中
    this(nameParam, ageParam)
    this.empNo = empNoParam
    //9.执行完Emp的主构造器，输出此println
    println("子类辅助构造器")
    super.hiPeople//利用super调用父类中的方法
    println(s"9.name=${name},age=${age},empNo=${empNo}")
  }
  //8.执行完了父类中的构造器后，输出此println
  println("子类主构造器")
}

object Test3 {
  def main(args: Array[String]): Unit = {
    //1.开始执行
    new Emp("flower", 23, 1002)
  }
}