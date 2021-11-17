package oop

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * @ClassName ScalaDemo-Test20 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年11月01日13:50 - 周一
 * @Describe
 */
object Test20 {
  def main(args: Array[String]): Unit = {
    val stu1: Worker16 = new Worker16(null)
    val stu2: Student16 = new Student16(stu1)
    val stu3: Teacher16 = new Teacher16(stu2)

//    println(stu3.getStore.getStore)

    //这样就循环除了stu3的依赖
      stu3.getStores.foreach(
        x=>{
          println(x.person)
          x.person.getStores.foreach(
            y=>{
              println(y.person)
            }
          )
        }
      )

  }

}

class Store(p: Person16) {
  def person: Person16 = p
}

abstract class Person16(p: Person16, ss: Seq[Store]) {

  def this(person16: Person16) {
    this(person16, List(new Store(person16)))//给Store加个List是好用foreach
  }
  //这是给别人循环的
  var getStores: Seq[Store] = ss

  var getStore: Person16 = p

}


class Worker16(p: Person16) extends Person16(p: Person16) {

}

class Student16(p: Person16) extends Person16(p: Person16) {

}

class Teacher16(p: Person16) extends Person16(p: Person16) {}
