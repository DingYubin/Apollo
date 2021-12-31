package com.apollo.elegant

class HelloWorld {

}

fun main() {
    println("HelloWorld, Apollo!")
    //只读
    val list = listOf("a", "b", "c")
    list.forEach { println(it) }

    val maps = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((k, v) in maps) {
        println("$k -> $v")
    }

    maps.forEach { (key, value) -> println("$key -> $value") }
}

private fun <K, V> Map<K, V>.forEach() {

}
