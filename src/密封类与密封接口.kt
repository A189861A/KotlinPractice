/*
* 密封类 / 密封接口（超级加强版的枚举类） = 严格限制 “子类数量” 的类 / 接口，专门用于【有限种类的状态、结果、事件】。
* 1. 密封类：定义主构造函数，接收参数，返回实例对象。
* 2. 密封接口：定义方法，返回值为密封类的实例对象。
* 3. 密封类的子类：必须在密封类的定义中，否则会编译错误。
* 4. 密封接口的实现类：必须在密封接口的定义中，否则会编译错误。
* */

// 密封类：表示所有可能的结果
// <out T>：协变，允许 Result<Int> 赋值给 Result<Number>
sealed class Result<out T> {
    /*
    * data class ：数据类
    *
    * */
    // 成功 → 携带数据
    data class Success<out T>(val data: T) : Result<T>()

    // 失败 → 携带错误信息
    data class Error(val exception: Exception) : Result<Nothing>()

    // 加载中 → 单例
    // object 声明：Loading 是 Result<Nothing> 的单例子类
    object Loading : Result<Nothing>()
}

fun handleResult(result: Result<String>) {
    // 直接使用，无需 new 实例对象
    when (result) {
        is Result.Success -> {
            println("成功：${result.data}")
        }
        is Result.Error -> {
            println("失败：${result.exception.message}")
        }
        Result.Loading -> {
            println("加载中...") // 直接引用单例
        }
        // 不用 else！编译器已经确保所有类型都处理了
    }
}