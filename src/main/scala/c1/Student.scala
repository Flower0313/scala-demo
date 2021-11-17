package c1

/**
 * @ClassName ScalaDemo-Student 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日11:21 - 周四
 * @Describe scala中定义student类
 */

//直接在类中定义属性，类似java中的构造方法，会放在Student.class中
class Student(val name: String, age: Int) {
  //注意构造器中的两个参数,name是Student的属性，age只有在类中被引用才会变成属性
  def show()={
    println(age)
  }

}

//引入伴生对象,充当static关键字,名称必须一样而且要在同一个文件里
//放在Student$.class中
object Student {
  def main(args: Array[String]): Unit = {
    println("flower")
  }
}
