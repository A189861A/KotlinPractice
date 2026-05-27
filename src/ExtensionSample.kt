/*
* 扩展函数 = 给别人的类，加一个新方法，不用继承、不用修改源码！
* 语法：
    fun 类名.扩展函数名(参数)：返回值 {
        // this = 调用者对象, 谁调用，this 就是谁
    }
*
* 静态调用，没有多态
    编译时就确定，不依赖继承
* */

// 1. 给 String 类扩展一个方法
fun String.isPhone(): Boolean {
    // this 代表调用这个函数的字符串本身
    return this.length == 11
}

// 2. 直接用！
fun main() {
    val phone = "13800138000"

    // 字符串直接调用扩展函数
    if (phone.isPhone()) {
        println("是手机号")
    } else {
        println("不是手机号")
    }
}