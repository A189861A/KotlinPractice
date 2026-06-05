/*
* 可见性修饰符:
     修饰符	    范围	            适用
    public	    所有地方	        默认
    private	    当前类/当前文件	内部工具、变量
    protected	前类 + 子类	    继承使用
    internal	同一个模块	    组件、SDK 内部类
* */

//public 修饰符: 所有地方都可以访问，是默认的
class UserD // 等价于 public class UserD

//private 修饰符: 只能在当前类/当前文件中访问
class UserF {
    private val name = "张三" // 只有这个类内部能用
}

//protected 修饰符: 只能被继承类访问
open class Parent {
    protected val age = 18
}

class Child : Parent() {
    fun test() {
        age // 可以访问父类的 protected 成员
        println(age)
    }
}

fun main(args: Array<String>) {
    val child = Child()
    child.test()
}


// internal（模块私有，Kotlin 独有）
// 同一个模块（module）内都能访问
// 模块外看不见
// 多用于 SDK 开发 / 组件化架构
internal class InternalClass // 只在本模块可见