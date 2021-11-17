package oop

/**
 * @ClassName ScalaDemo-Person13 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日10:10 - 周日
 * @Describe 类型检查和转换
 */



class Person13 {

}

object Person13{
  def main(args: Array[String]): Unit = {
    val person = new Person13
    //判断对象，相当于java中的 a instanceof A
    val bool:Boolean = person.isInstanceOf[Person13];

    if(bool){
      //转换对象，相当于java中的A a = (A) b
      val p1:Person13 = person.asInstanceOf[Person13]
      println(p1)
    }

    //获取类的相关信息,相当于java中的<类.class>
    val pClass:Class[Person13] = classOf[Person13]
    println(pClass)


  }
}

