fun main() {
    val name = "Kotlin"
    println("Hello, " + name + "!")

    for (i in 1..5) {
        println("i = $i")
    }

    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }

    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }

}