package oop

/**
 * @ClassName ScalaDemo-MyBall 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月16日23:10 - 周六
 * @Describe 特质的第2种特性：钻石叠加
 */

//第一层Trait
trait Ball {
  def describe(): String = {
    "ball"
  }
}

//第二层Trait
trait Color extends Ball {
  override def describe(): String = {
    "blue-" + super.describe()
  }
}

//第二层Trait
trait Category extends Ball {
  override def describe(): String = {
    "foot-" + super.describe()
  }
}

//第三层类
class MyBall extends Category with Color {
  override def describe(): String = {
    //执行父类的顺序是从右至左，即Color第一个执行，然后才是Category
    "my ball is a "+super.describe()//my ball is a blue-foot-ball
  }
}

object Test11{
  def main(args: Array[String]): Unit = {
    println(new MyBall().describe())
  }
}
