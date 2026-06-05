/*
* 操作符重载: 给 + - × / == > [] 这些符号，自定义它们的功能。
*
      符号  	函数名	    作用
    a + b	plus	    加
    a - b	minus	    减
    a * b	times	    乘
    a / b	div	        除
    a == b	equals	    等于
    a > b	compareTo	大于
    a[b]	get	        下标
*
* */
data class UserC(val age: Int) {
    operator fun plus(other: UserC): Int {
        return this.age + other.age
    }
    operator fun get(index: Int): Int {
        return age
    }
}

val suer1 = UserC(21)
val suer2 = UserC(22)


fun main() {
    val total = suer1 + suer2
    println("total: $total");
    println("age-1: ${suer1[0]}");
    println("age-2: ${suer2[3]}");
}