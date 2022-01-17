package com.apollo.elegant.expression

/**
 * 匿名函数
 */
class Anonymous {

}

val func = fun(){
    println("Hello")
}

val lambda = {
    println("Hello")
}

val f1 = { p:Int ->
    println(p)
    "Hello"
}

fun main() {
    println(f1(2))
}