package c2

/**
 * @ClassName ScalaDemo-Test02_Comment 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日15:35 - 周四
 * @Describe 标识符
 */
object Test02_Variable {
  def main(args: Array[String]): Unit = {
    var Int: String = "hello Int" //Int是预定义字符，不是关键字
    var _: String = "hello _" //这里_被认为是一个方法
    println(Int)

    var `if`: String = "hello if"
    println(`if`)
  }
}
