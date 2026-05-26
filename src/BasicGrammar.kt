fun main() {
//    tempStr()
//    println("max of 0 and 42 is ${maxOf(0, 42)}")
//    forSample()
//    whileSample();
//    whenSample(32L)
//    rangeSample()
//    collectionSample()
//    println(parseInt("123"))
//    println(isInt("123"))
//    println(getStringLength("1234"))
//    forMap()
//      println(pLazy)
    println("Hello world!".spaceToCamelCase())
}



// 字符串模板
fun tempStr() {
    //sampleStart
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"
    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    //sampleEnd
    println("s2= " + s2)
}

// 条件表达式
fun maxOf(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// for 循环
fun forSample() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    // 在 Kotlin 中，indices 是 Collection 的一个扩展属性，返回一个 IntRange，表示集合的有效下标范围。
    // items.indices == 0..2  (IntRange from 0 to size-1)
    // 0 until items.size
    for(index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun whileSample() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while ( index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun whenSample(obj: Any): Unit {
    val ret: String = when (obj) {
        1 -> "one"
        "Hello" -> "world"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }
    println(ret)
}

// 区间range
fun rangeSample() {
    for (i in 1..5 step 2) {
        print(i)
    }
    for(x in 5 downTo 0 step 1) {
        print(x)
    }
    // 使用 in 操作符来检测某个数字是否在指定区间内:
    if (3 in 1..3) {
        print(true)
    }
}

// 集合操作
fun collectionSample() {
    val fruits = listOf("avocado","apple", "banana", "kiwi")
//    lambda 表达式
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

// ?: 空值与空检测
fun parseInt(str: String): Int? {
    return str.toIntOrNull() // 将字符串转换为整数
}

// is 操作符检测一个表达式是否某类型的一个实例
fun isInt(obj: Any): Boolean {
    return obj is Int
}
fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null
    // `obj` 在这一分支自动转换为 `String`
    return obj.length
}

//函数的默认实参
fun foo(a: Int = 0, b: String = "") { }

// for 循环遍历 Map
fun forMap() {
    val map = mapOf("a" to 1, "b" to 2)
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

//区间迭代
//for (i in 1..100) { …… } // 闭区间：包含 100
//for (i in 1..< 100) { …… } // 左闭右开区间：不包含 100
//for (x in 2..10 step 2) { …… }
//for (x in 10 downTo 1) { …… }
//(1..10).forEach { …… }

//延迟属性
val pLazy: String by lazy { "Hello, World!" } // 延迟初始化，直到第一次访问时才计算

// 拓展函数
fun String.spaceToCamelCase(): String {
    val words = this.split(" ")

    if (words.isEmpty()) return this
    /*
    * mapIndexed 函数：
    *   功能: 对集合中的每个元素应用一个函数，同时保留元素的索引信息
    *   返回值: List<R> - 转换后的新列表
    *     index：元素的索引
    *     word：元素本身
    * */
    return words.mapIndexed { index, word ->
        if (index == 0) {
            word.lowercase()  // 首单词保持小写
        } else {
            word.lowercase().replaceFirstChar { it.uppercase() }  // 后续单词首字母大写
        }
    }.joinToString("")
}

//对象声明（Object Declaration） --- 创建单例
/*
    本质: 定义一个单例类，全局只有一个实例
    初始化：首次访问时懒加载初始化
    调用方式：直接通过类名访问：Resource.name
* */
object Resource {
    val name = "Name"
}

//伴生对象
/*
* 每个类最多只能有一个伴生对象
* 伴生对象的成员可以通过类名直接访问（无需创建实例）
* 相当于 Java 中的静态成员（static）
* */
class MyClass { // 定义一个普通类
    /* 优点：
    * 封装创建逻辑：对象创建细节隐藏在 create() 方法中
    * 解耦：调用方不需要知道对象是如何创建的
    * 灵活性：可在 create() 中添加复杂的初始化逻辑
    * */
    companion object Factory { // 声明一个伴生对象，命名为Factory，也可以无名称，默认名称为 Companion
        fun create(): MyClass { // 半生对象的方法，用于创建 MyClass 类的实例
            return MyClass()
        }
    }
}
// 访问方式：通过类名直接调用，无需创建实例
// MyClass.Factory.create()  // 完整写法
// MyClass.create()          // 简化写法（推荐）

//对象表达式（Object Expression）—— 匿名内部类
//val listener = object : OnClickListener {
//    override fun onClick() {
//        println("Clicked!")
//    }
//}

// 完整示例
class Person private constructor(val name: String) {
    companion object Factory {
        fun create(name: String): Person {
            // 可添加校验逻辑
            if (name.isEmpty()) {
                throw IllegalArgumentException("Name cannot be empty")
            }
            return Person(name)
        }
    }
}

// 使用
val person = Person.create("Alice")
//println(person.name)  // → "Alice"














