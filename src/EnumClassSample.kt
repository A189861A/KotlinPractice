import kotlin.collections.contentToString

// 普通枚举
enum class Color {
    RED, GREEN, BLUE // 固定常量
}

//带参数的枚举
//1. 枚举类定义主构造函数：接收 code、msg 两个参数
enum class State(val code: Int, val msg: String) {
    // 2. 每一个枚举项 = 调用构造函数创建实例，传参 code、msg 两个参数
    SUCCESS(200, "请求成功"), // 序号从 0 开始
    ERROR(500, "服务器错误"),
    LOADING(100, "加载中"); // 最后一项加分号，后续可以写成员/方法

    // 可选：自定义方法
    // 成员方法 → 通过实例调用
    fun getInfo(): String {
        return "编码：$code，描述：$msg";  // 省略 this.
        // 等价于：
//        return "编码：${this.code}，描述：${this.msg}";  // 完整写法
    }

    // 静态查找：根据 code 查找对应的举项
    companion object {
        // 1. 定义一个静态方法，接收 code 参数，返回对应的举项
        // 静态方法 → 通过类名调用
        fun fromCode(code: Int): State? {
            // values() 是 Kotlin 枚举类的内置方法，由编译器自动生成，无需手动定义。
            // 返回一个包含枚举类所有枚举项的数组，顺序与枚举项声明顺序一致。
            val stateStr1 = State.values().contentToString()
            println("State.values() contentToString: $stateStr1") // [SUCCESS, ERROR, LOADING]
            return values().firstOrNull { it.code == code }
        }
    }
}

fun main() {
    val color = Color.RED

    // 判断
    when (color) {
        Color.RED -> println("红色")
        Color.GREEN -> println("绿色")
        Color.BLUE -> println("蓝色")
    }

    println(State.SUCCESS.code) // 200
    println(State.ERROR.msg)  // 服务器错误

    /*
    * 每个枚举项（SUCCESS、ERROR、LOADING）都是 State 类的实例对象，因此可以直接调用其实例方法 getInfo()
    * */
    println(State.LOADING.getInfo()) // 编码：100，描述：加载中

    // 静态查找：根据 code 查找对应的枚举项
    val state = State.fromCode(200)
    println(state?.getInfo()) // 编码：200，描述：请求成功
    println(state?.msg) // 请求成功

}