// 集合常用函数 + Sequence 示例
fun testCollection() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    // 转换、过滤
    val newList = list.map { it * 2 }.filter { it > 5 }
    // 查找
    val findItem = list.find { it == 3 }
    // 扁平化
    val nestList = listOf(listOf(1,2), listOf(3,4))
    val flatList = nestList.flatMap { it }

    // Sequence 延迟计算，大数据性能更优
    val sequenceResult = list.asSequence()
        .map { it * 3 }
        .filter { it < 15 }
        .toList()
}

fun main(){
    testCollection()
}