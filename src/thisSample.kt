/*
* 在类的成员中， this 指的是该类的当前对象
* 在扩展函数或者带有接收者的函数字面值中， this 表示在点左侧传递的 接收者 参数。
* */
// 外部类 A
class A { // 隐式标签 @A
    // 内部类 B，依赖于外部类 A
    // 内部类 B 可以访问外部类 A 的属性和方法
    /*
    * 关键字	：inner
    * 作用	：声明一个可以访问外部类成员的嵌套类
    * 特性	：内部类持有外部类的引用
    * */
    private  val x = 10
    inner class B { // 隐式标签 @B
        // fun Int.foo() 是 Kotlin 中扩展函数的语法，表示为 Int 类型添加一个名为 foo 的方法。
        fun Int.foo() { // 隐式标签 @foo
            // 访问外部类 A 的属性 x
            println(x)

            val a = this@A // A 的 this
            val b = this@B // B 的 this
            val c = this // foo() 的接收者，一个 Int
            val c1 = this@foo // foo() 的接收者，一个 Int
            val funLit = lambda@ fun String.() {
                val d = this // funLit 的接收者，一个 String
            }
            val funLit2 = { s: String ->
                // foo() 的接收者，因为它包含的 lambda 表达式 没有任何接收者
                val d1 = this
            }
        }
        // 提供一个包装方法
        fun callFooOnInt(num: Int) {
            num.foo()
        }
    }
}

/*
* this 的标签用法：
class A { // 隐式标签 @A
    inner class B { // 隐式标签 @B
        fun Int.foo() { // 隐式标签 @foo
            val a = this@A // 引用外部类 A 的实例
            val b = this@B // 引用内部类 B 的实例
            val c = this   // 引用扩展函数的接收者（Int）
            val c1 = this@foo // 同上，显式指定标签
        }
    }
}
*
* */

fun main() {
    val a = A() // 创建外部类 A 的实例
    val b = a.B() // 通过外部类实例创建内部类 B 的实例
    //  22.foo() // ❌ 错误：foo 不在当前作用域内

    b.callFooOnInt(22)  // ✅ 通过 B 的实例间接调用
}
