package com.apollo.elegant.expression

import com.apollo.elegant.bean.Rectangle
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class Turtle {
    fun penDown() {
        println("penDown")
    }
    fun penUp() {
        println("penUp")
    }
    fun turn(degrees: Double) {
        println("turn degrees = $degrees")
    }
    fun forward(pixels: Double) {
        println("forward pixels = $pixels")
    }
}

val myTurtle = Turtle()

fun main() {
//    handleWith()
//    println(myRectangle.toString())
//    handUse()
//    handleAlso()
//    greetMammal(Cat("Snowy"))
//    println("stringToSomething = " + stringToSomething)
//    println("stringToInt = " + stringToInt)
//    println("stringToList = " + stringToList)
//    println("stringToStringList = " + stringToStringList)
}

/**
 * 对一个对象实例调用多个方法 （with）
 */
fun handleWith(){
    with(myTurtle) { // 画一个 100 像素的正方形
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}


/**
 * 配置对象的属性（apply）
 */
val myRectangle = Rectangle(6).apply {
    length = 4
    breadth = 5
    color = "0xFAFAFA"
}

/**
 * 使用资源文件
 */
fun handUse(){
    Files.newInputStream(Paths.get("/Users/dingyubin/resp/apollo/src/main/kotlin/com/apollo/elegant/expression/Habit.kt"))
        .buffered().reader().use {
            reader -> println(reader.readText())
        }
}

/**
 * 交换两个变量
 */
fun handleAlso(){
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a = $a, b = $b")
}

/**
 * 密封类
 */
sealed class Mammal(val name: String)                                                   // 1

class Cat(val catName: String) : Mammal(catName)                                        // 2
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {                                                                     // 3
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"    // 4
        is Cat -> return "Hello ${mammal.name}"                                         // 5
    }                                                                                   // 6
}

//sampleStart
inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}

val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)

val stringToSomething = somePair.asPairOf<String, Any>()
val stringToInt = somePair.asPairOf<String, Int>()
val stringToList = somePair.asPairOf<String, List<*>>()
val stringToStringList = somePair.asPairOf<String, List<String>>() // Compiles but breaks type safety!
// Expand the sample for more details