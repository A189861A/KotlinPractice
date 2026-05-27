// 1. 定义接口
interface Printer {
    fun print()
}

// 2. 委托对象（真正干活的）
class RealPrinter : Printer {
    override fun print() {
        println("我是委托对象，正在打印...")
    }
}

// 3. 委托类（自己不干活，交给 RealPrinter）
/*
* by 关键字：委托实现
* */
class MyPrinter(p: Printer) : Printer by p

// 测试
fun main() {
    val real = RealPrinter()
    val my = MyPrinter(real)

    my.print() // 调用的其实是 RealPrinter 的方法！
}