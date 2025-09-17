package src

fun main() {
    val a = 10
    val b = 15
    println(sum(a, b))
    println(diff(a, b))
    println(multiply(a, b))
    println(div(a, b))
}

fun sum(a: Int, b:Int):Int {
    return a + b;
}

fun diff(a: Int, b:Int):Int {
    return a - b;
}
fun multiply(a: Int, b:Int):Int {
    return a * b;
}
fun div(a: Int, b:Int):Int {
    return a / b;
}