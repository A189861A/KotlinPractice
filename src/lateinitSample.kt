/*
* lateinit 关键字: 延后初始化
* 作用：在属性值被赋值前，不能使用该属性
* 特性：在属性值被赋值后，才能使用该属性
* 延迟初始化：在属性值被赋值前，不能使用该属性
* 缓存机制：在属性值被赋值后，后续访问直接返回缓存值
* */
class UserB {
    // 先声明，不赋值
    lateinit var name: String
    var age: String? = null  // 可空类型，每次用都要判空

    fun init() {
        // 后面再赋值
        name = "小明"
    }

    fun show() {
        /*
        * :: 是 Kotlin 中的引用操作符，用于创建属性引用、函数引用或类引用。
            用法	   	    语法	             说明
            属性引用	::propertyName	     获取属性的引用对象
            函数引用	::functionName	     获取函数的引用对象
            类引用	ClassName::class	 获取类的运行时引用
            构造函数引用	::ClassName	     获取构造函数的引用
          *
        * ::name 是对属性 name 的引用
        * */
        // 检查是否已经初始化（Kotlin 独有属性 isInitialized ）
        if (::name.isInitialized) {
            println("已经赋值--" + ::name)
        } else {
            println("还没赋值")
        }
        println(name) // 用的时候已经有值了
    }
}

// 函数
fun greet(name: String) = println("Hello, $name")

fun main() {
    val user = UserB()
    user.init()  // 先赋值
    user.show()  // 再使用

    // ::greet 获取函数引用
    val funcRef: (String) -> Unit = ::greet
    funcRef("Kotlin")  // 调用：Hello, Kotlin

    // 类引用
    val classRef = UserB::class
    println("类名--${classRef.simpleName}")      // 输出: UserB（类名）

    // 1. 基本信息
    println("类名: ${classRef.simpleName}")

}


















