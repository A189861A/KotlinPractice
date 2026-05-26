abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()

}

fun main() {
    /*
    * object：匿名对象
    * */
    val myObject = object : MyAbstractClass(){
        override fun doSomething() {
            println("Doing something...")
        }

        override fun sleep() {
            println("Sleeping...")
        }
    }
    myObject.doSomething()
}