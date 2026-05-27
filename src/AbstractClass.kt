abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()

}

class Student {
    /*
    * Kotlin 中 var 属性自动生成 getter/setter，不需要手写 setName()/setAge()，
    * 直接用 stu.name = "小明" 赋值即可。
    * */
    var name = ""
    var age = 0

    fun showInfo() {
        println("姓名：$name，年龄：$age")
    }
}

class B {
    fun foo() {
        println("B.foo()")
    }
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

    // 实例化 Student 类
    val stu = Student()

    // 普通写法（要一直写 stu.）
    stu.name = "小明"
    stu.age = 18
    stu.showInfo()

    println("-----------")

    // with 写法（不用写 stu.）
    with(stu) {
        name = "小红" // 直接赋值属性
        age = 20
        showInfo()
    }

    // 调用 class B 的 foo 方法
    B().foo()

}


