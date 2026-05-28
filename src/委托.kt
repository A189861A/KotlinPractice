/*
* 👉 委托类（自己）不能访问委托对象里的私有成员、额外成员！
* 👉 只能访问【接口规定的方法】！
*
* */

// 1.接口(约定好的方法)
interface Animal {
    fun eat() // 只有这个方法是公开约定的
}
//  2.委托对象（真正干活的）
class Dog : Animal {
    // 接口方法（委托可以访问）
    override fun eat() {
        println("狗吃骨头")
    }

    // 自己额外的方法（委托 不能访问！）
    fun run() {
        println("狗跑")
    }

    // 自己的私有成员（更不能访问）
    private val age = 10
}
//  3.委托类（by 关键字）
class MyPet(animal: Animal) : Animal by animal


fun main() {
    val dog = Dog()
    val pet = MyPet(dog)

    pet.eat() // ✅ 可以（接口方法）

//    pet.run() // ❌ 报错！不能访问委托对象的额外方法
//    pet.age   // ❌ 报错！更不能访问私有成员
}
