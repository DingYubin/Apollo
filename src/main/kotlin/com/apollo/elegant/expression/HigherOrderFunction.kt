package com.apollo.elegant.expression

class HigherOrderFunction {
}

fun main(){
    cost{
        val fibonacciNext = fibonacci()
        for (i in 0..10){
            println(fibonacciNext())
        }
    }
}

/**
 * inline 内联函数
 */
inline fun cost(block:() -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println("cost = ${System.currentTimeMillis() - start} ms")
}

fun fibonacci():() -> Long {
    var first = 0L
    var second = 1L
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}

//non-local return
inline fun Runnable(crossinline block: () -> Unit): Runnable {
    return java.lang.Runnable { block() }
}