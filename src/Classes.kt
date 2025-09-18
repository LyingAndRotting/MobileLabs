package src

fun main() {
    val dog = Dog(10, true)
    val cat = Cat(5, true)
    dog.speak()
    cat.speak()
}

abstract class Animal {
    abstract val age:Int
    abstract val isFurry:Boolean
    abstract fun speak()
}

class Dog(
    override val age: Int,
    override val isFurry: Boolean
) : Animal() {
    override fun speak() {
        println("bark")
    }
    init {
        println(age)
    }
}

class Cat (
    override val age: Int,
    override val isFurry: Boolean
) : Animal() {
    override fun speak() {
        println("meow")
    }
    init {
        println(age)
    }
}