package c2

import java.io.{File, PrintWriter}
import scala.io.Source

/**
 * @ClassName ScalaDemo-Test05_Comment 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月07日16:05 - 周四
 * @Describe 数据类型
 */
object Test05_FileIO {
  def main(args: Array[String]): Unit = {
    //1.从文件中读取数据(相对路径)
    Source.fromFile("src/main/resources/info.txt").foreach(print)

    //2.将数据写入文件
    var writer = new PrintWriter(new File("src/main/resources/output.txt"));
    writer.write("1005 lcf 29")
    writer.close()
  }
}
