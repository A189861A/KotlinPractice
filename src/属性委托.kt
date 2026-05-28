/*
* 属性委托（by 关键字）: 属性的 get () 和 set () 交给别人去做，自己不实现
* 核心语法:
    class 类 {
        var 属性: 类型 by 委托对象
    }
* */

import kotlin.reflect.KProperty

// 委托类
class MyDelegate {
    /*
    * 取值：调用 getValue() 方法
    * 赋值：调用 setValue() 方法
    * 参数：
        - thisRef: 当前对象实例（调用者） 委托属性所属对象的引用（即 by 前面属性所在的类实例）
        - property: 当前属性对象（调用者） 属性的元数据对象，包含属性名、类型等信息
    * value: 赋值的值（调用者）
    * 返回值：取值的值（调用者）
    *
    * operator 关键字：操作符重载关键字，用于标记一个方法可以作为操作符被隐式调用。
    * */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "我是委托返回的值"
    }

    // 赋值
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("你设置的值是：$value")
    }
}

// 使用 by 委托属性
class Test {
    /*
    * thisRef 就是 Test 类的实例 t
    * 当调用 t.msg 时，thisRef 就是 t 对象。
    * */
    // 属性交给 MyDelegate 管理
    var msg: String by MyDelegate()
}

fun main() {
    val t = Test()
    /*
    ┌─────────────────────────────────────────────────────┐
    │ 代码: println(t.msg)                                │
    │       ↓                                            │
    │ 编译器自动转换为:                                     │
    │ println(myDelegate.getValue(t, Test::msg))          │
    │       ↓                                            │
    │ 调用 MyDelegate 的 getValue() 方法                   │
    │       ↓                                            │
    │ 返回 "我是委托返回的值"                             │
    └─────────────────────────────────────────────────────┘
    * */
    println(t.msg) // 调用 getValue()

    t.msg = "测试"  // 调用 setValue()
}
















