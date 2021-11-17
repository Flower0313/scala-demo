package generic

/**
 * @ClassName ScalaDemo-GenericTest1 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日13:51 - 周二
 * @Describe 泛型的协变和逆变
 */
object GenericTest1 {
  def main(args: Array[String]): Unit = {
    //协变和逆变(多态)
    var father1: subList[Father] = new subList[Father]
    //var father2:subList[Father] = new subList[Son] 会错误
    var son1: subList[Son] = new subList[Father]
    father1.show(new Son())
    son1.show(new SubSon())

    var father2: plusList[Father] = new plusList[Son]
    //var son2:plusList[Son] = new plusList[Father]//会错误
    var father3: plusList[Father] = new plusList[SubSon]

    var son3: medList[Son] = new medList[Son]

    var father4: AA[Father] = new AA[Father] //AA中类型也必须相同

    //var father5: AA[SubSon] = new AA[SubSon] 报错

  }
}

class subList[-T] {
  def show(x: T): Unit = {
    println("-T")
  }

} //-T表示逆变

class medList[T] //T表示不变

class plusList[+T] {

} //+T表示协变

class AA[T >: Son]

class Father

class Son extends Father

class SubSon extends Son
