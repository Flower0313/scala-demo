package oop

/**
 * @ClassName ScalaDemo-User 
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月17日0:17 - 周日
 * @Describe 特质自身类型
 */
class User(val name: String, val password:String)


trait UserDao{
  //这里_只是一个别名，在这里声明啥都可以
  self:User=> //将UserDao自身类型定义为User，可以认为里面就有一个User
  def insert()={
    println("insert into db:"+this.name)//这里name就是User中的
  }
}

class RegisterUser(name: String, password: String)extends User(name,password) with UserDao


object Test12{
  def main(args: Array[String]): Unit = {
   val user =  new RegisterUser("flower","root")
    user.insert()
  }
}
