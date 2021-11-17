//这里报错是因为与idea层级目录不对应，主要是idea对scala优化不好，代码不报错就行
package com {


  object Outer {
    var out: String = "out"

    def main(args: Array[String]): Unit = {
      import com.atguigu.Inner //父包访问子包需要导包，这样导入的话只有这个main方法才能用
      println(Inner.in)
    }
  }
  package atguigu {
    object Inner {
      val in: String = "in"

      def main(args: Array[String]): Unit = {
        Outer.out = "new out"
        println(Outer.out) //子包访问父包无需导包
      }
    }
  }

}

package oop {
  object test1_package {
    def main(args: Array[String]): Unit = {
      println("主类")
    }
  }
}

