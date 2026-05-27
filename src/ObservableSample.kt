import kotlin.properties.Delegates

/*
* 属性委托：observable 委托
* 作用：在属性值发生变化时，自动通知观察者
* 特性：在属性值发生变化时，会自动调用观察者的方法
* */
fun main() {
    /*
    *   0	属性的初始值
        property	属性本身的引用（通常用 _ 忽略，因为很少用到）
        old	修改前的旧值
        new	修改后的新值
    * */
    var age: Int by Delegates.observable(0) { property, old, new ->
        println("年龄--$property-- 从 $old 改成 $new")
    }

    age = 18
    age = 20
}