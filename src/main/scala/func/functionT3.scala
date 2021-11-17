package func

/**
 * @ClassName ScalaDemo-functionT3 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月14日10:40 - 周四
 * @Describe 函数参数
 */
object functionT3 {
  def main(args: Array[String]): Unit = {
    //可变参数
    def test1(s: String*): Unit = {
      println(s)
    }

    test1() // 没有参数输出List()
    test1("xiaohua") //有参数输出WrappedArray(xiaohua)
    test1("xiao", "hua") // 多个参数输出WrappedArray(xiao, hua)

    //若有特定的参数，那可变参数应放在最后
    def test2(name: String, s: String*): Unit = {
      println(name + "," + s)
    }

    test2("xiaohua", "flower", "holdenxiao") //输出xiaohua,WrappedArray(flower, holdenxiao)

    //参数默认值,有默认值的参数和可变参数一样也应该放在最后面，防止二义性
    def test3(name: String, age: Int = 18): Unit = {
      println(s"$name,$age")
    }

    test3("xiaohua") //xiaohua,18
    test3("flower", 20) //flower,20

    //若没有将带默认值的参数放在最后，那么在调用的时候要采用带名参数的方式,不然会报错
    def test4( sex : String = "男", name : String ): Unit = {
      println(s"$name, $sex")
    }
    test4(name="ximenqing")//ximenqing, 男



  }
}
