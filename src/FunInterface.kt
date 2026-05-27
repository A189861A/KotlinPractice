// 定义：函数式接口
fun interface OnClick {
    fun click() // 只有一个抽象方法
}

// 使用
fun setClick(listener: OnClick) {
    listener.click()
}

fun main() {
    // 传入 Lambda
    /*
     1. Lambda 被转换为 OnClick 实例
     2. setClick 接收这个实例
     3. setClick 内部调用 listener.click()
     4. 执行 println("点击了")

    * object : 接口() = 创建一个匿名内部类 **直接实现这个接口！**
    ┌─────────────────────────────────────────────────────┐
    │ setClick { println("点击了") }                      │
    │                    ↓                               │
    │ 编译器自动转换为：                                   │
    │ setClick(object : OnClick {                        │
    │     override fun click() {                         │
    │         println("点击了")                          │
    │     }                                              │
    │ })                                                 │
    │                    ↓                               │
    │ 调用 listener.click() → 执行 println("点击了")      │
    └─────────────────────────────────────────────────────┘
    * */

    /*
    * SAM 转换 = 用 Lambda 代替 接口 匿名内部类
    * 不用写繁琐的 object : 接口() 了，直接一行 Lambda
    * */
    // 1. Lambda 被转换为 OnClick 实例
    setClick { println("点击了") }

}