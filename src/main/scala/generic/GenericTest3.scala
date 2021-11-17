package generic

import com.sun.deploy.perf.PerfRollup

/**
 * @ClassName ScalaDemo-GenericTest3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日16:03 - 周二
 * @Describe 上下文限定
 */
object GenericTest3 {
  //定义一个隐式值(Ordering[T]类型的)，并重写排序方式,类型是Ordering[Person]的隐式值,它的作用和java中的comparetor一样，临时定义来比较大小的
  //这里必须要写具体的值(而不是泛型)，因为这里就相当于补充
  //Ordering[Person]隶属于Ordering[T]
  implicit val personComparator: Ordering[Person] = new Ordering[Person] {
    //重写compare
    override def compare(x: Person, y: Person): Int = {
      x.age - y.age
    }
  }

  def main(args: Array[String]): Unit = {
    val jack = new Person("jack", 20)
    val tom = new Person("tom", 30)

    val compareComm = new CompareComm(jack, tom)
    println(compareComm.greater)

    println("---------------------------")

    val compareComm2 = new CompareComm2(jack, tom)
    println(compareComm2.greater)

    println("---------------------------")

    val compareComm3 = new CompareComm3(jack, tom)
    println(compareComm3.greater)

  }
}

class Person(val name: String, val age: Int) {
  override def toString: String = this.name + "\t" + this.age
}

class Student(val name: String, val age: Int) {
  override def toString: String = this.name + "\t" + this.age
}


//方式一：隐式参数会自动寻找代码域中符合Ordering[T]的隐式值,有的话就传递给compartor
class CompareComm[T: Ordering](obj1: T, obj2: T)(implicit comparator: Ordering[T]) {
  def greater: T = if (comparator.compare(obj1, obj2) > 0) obj1 else obj2
}

//方式二：使用implicitly语法糖
class CompareComm2[T: Ordering](obj1: T, obj2: T) {
  def greater = {
    //发生隐式转换，获取隐式值
    val comparetor = implicitly[Ordering[T]]

    if (comparetor.compare(obj1, obj2) > 0) obj1 else obj2
  }
}
//方式三：
class CompareComm3[T: Ordering](o1: T, o2: T) {
  def greater: T = {
    //定义f1
    def f1()(implicit flower: Ordering[T]) = flower.compare(o1, o2) //这个flower就是我们之前定义隐式方法类

    //调用f1
    if (f1() > 0) o1 else o2
  }
}











