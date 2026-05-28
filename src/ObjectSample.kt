// Kotlin：对象声明 vs 对象表达式（超级清晰）
/*
1. 对象声明（object 单例）
    声明一个单例类，全局只有一个对象，永远用这一个。
    object 类名 {
        // 属性、方法
    }
2. 对象表达式（object : ）
    临时创建一个匿名对象，用一次就丢，相当于匿名内部类。
    object : 接口/父类() {
        // 属性、方法
        // 重写方法
    }
* */

// 对象声明 = 单例
object AppConfig {
    val version = "1.0"

    fun show() {
        println("我是单例对象")
    }
}

/*
函数式接口 vs 普通接口
特性	        函数式接口 (fun interface)	普通接口 (interface)
抽象方法数量	只能有一个	                可以有多个
SAM 转换	    ✅ 支持	                    ❌ 不支持
Lambda 写法	✅ 可以	                    ❌ 不可以
* */

// 普通接口
interface Click {
    fun onClick()
}
// 函数式接口
fun interface Click2 {
    fun onClick()
}

fun main () {
    // 使用：直接用，不用 new
    AppConfig.show()    // 直接调用
    println(AppConfig.version)

    // 对象表达式 = 临时匿名对象 （传统写法）
    val listener = object : Click {
        override fun onClick() {
            println("点击了")
        }
    }
    listener.onClick()

    // Lambda 写法（更简洁）（函数式接口支持）（SAM 转换）
    val listener2 = Click2 { println("点击了2") }
    listener2.onClick()
}