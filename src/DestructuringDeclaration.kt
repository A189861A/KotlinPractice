// 数据类（自动支持解构）
/*
* 1. data class 数据类自动支持解构
* 2. 顺序必须和类里的属性顺序一致
* 3. 不需要的变量可以用 _ 忽略
* */
data class User(val name: String,val sex: String, val age: Int)

class UserA {
    // 普通属性（必须创建对象才能用）
    var name = "张三"

    // 🔥 伴生对象（静态区域）
    companion object {
        // 静态属性
        val version = "1.0"

        // 静态方法
        fun showVersion() {
            println("版本号：$version")
        }
    }
}

fun main() {
    val user = User("小明", "男", 18)
    // 🔥 结构赋值（解构）：一行拆出 name 和 age
    val (name, _, age) = user
    // 直接使用变量
    println("姓名：$name")
    println("年龄：$age")

    // Map 遍历
    val map = mapOf("name" to "小红", "age" to 20)

    // 解构遍历：直接拆出 key 和 value
    for ((key, value) in map) {
        println("$key -> $value")
    }

    // ✅ 直接用类名调用，不用创建对象！
    println(UserA.version)
    UserA.showVersion()
}