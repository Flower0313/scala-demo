package oop {
  /**
   * @ClassName ScalaDemo-package_02
   * @Author Holden_—__——___———____————_____Xiao
   * @Create 2021年10月15日10:34 - 周五
   * @Describe
   */
  //普通对象
  object package_02 {
    def main(args: Array[String]): Unit = {
      println(commonValue)
      //可以正常调用oop包对象中的内容
      //所以包对象相当于一个静态池，存储静态变量和静态方法
      commonMethod()
    }
  }
}

//如果不定义aaa包对象则会报错，一个包对象唯一
package aaa {
  package bbb {
    object package_02 {
      def main(args: Array[String]): Unit = {
        //可以使用自己包对象下定义的属性和方法
        println(school)
      }
    }
  }

  //包对象的声明要和包定义在同一层级下
  package object bbb {
    val school: String = "atguigu"
  }
}

//aaa的包对象
package object aaa {

}



