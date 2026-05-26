fun main() {
//    tempStr()
//    println("max of 0 and 42 is ${maxOf(0, 42)}")
//    forSample()
//    whileSample();
//    whenSample(32L)
//    rangeSample()
//    collectionSample()
//    println(parseInt("123"))
//      println(isInt("123"))
    println(getStringLength("1234"))
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








