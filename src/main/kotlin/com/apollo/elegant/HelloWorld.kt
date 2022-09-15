package com.apollo.elegant

class HelloWorld {

}

fun main() {
    println("i = ${0%1}")
    println("i = ${0%2}")
    println("i = ${1%1}")
    println("i = ${1%2}")

    val a = "22223"
    val b = 1
//    var rel = a.substring(b)

    var jumpUrl: String
//    if (b != -1) {
        jumpUrl = a.substring(b)

        jumpUrl = jumpUrl.replace("&jumpUrl=", "")
//    }

//    //只读
//    val list = listOf("a", "b", "c")
//    list.forEach { println(it) }
//
//    val maps = mapOf("a" to 1, "b" to 2, "c" to 3)
//    for ((k, v) in maps) {
//        println("$k -> $v")
//    }
//
//    maps.forEach { (key, value) -> println("$key -> $value") }
}

private fun <K, V> Map<K, V>.forEach() {

}
