// 一个普通类
class PersonA {
    var name = ""
    var age = 0
    var address = ""

    // 方法
    fun sayHi() = println("大家好，我是 $name")
}


/*
*   apply：专门用来给一个对象批量配置属性的函数。
*   语法：
    val 对象 = 类().apply {
        // 直接配置属性、调用方法
    }
* */
fun main() {
    // 🔥 使用 apply 一次性配置所有属性
    val PersonA = PersonA().apply {
        name = "张三"       // 不用写 PersonA.name
        age = 25            // 直接赋值
        address = "北京市"
        sayHi()             // 直接调用方法
    }

    // 配置完成，对象已经可用
    println("姓名：${PersonA.name}")
    println("年龄：${PersonA.age}")
}