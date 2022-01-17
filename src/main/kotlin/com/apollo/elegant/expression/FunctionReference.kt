package com.apollo.elegant.expression

import kotlin.reflect.KFunction3

/**
 * 函数的引用 类似C语言中的函数指针，可用于函数传递
 */
class FunctionReference {
    fun foo(){

    }

    fun foo(p0:Int) : String{
        return ""
    }

    fun bar(p0:String, p1:Long):Any{
        return ""
    }

    fun multiReturnValues() : Triple<Int, Long, Double> {
        return Triple(1, 3L, 4.0)
    }
}

fun foo(){

}

fun foo(p0:Int): String {
    return ""
}

fun main() {
    val f : (FunctionReference) -> Unit = FunctionReference::foo
    val k : () -> Unit = ::foo
    val n : (Int) -> String = ::foo
//    val f1 = FunctionReference :: foo

    val g : (FunctionReference, Int) -> String = FunctionReference::foo

    val h : (FunctionReference, String, Long) -> Any = FunctionReference::bar
    val h0 : FunctionReference.(String, Long) -> Any = FunctionReference::bar
    val h1 : KFunction3<FunctionReference, String, Long, Any> = FunctionReference::bar
    val h2 = FunctionReference::bar

    //绑定receiver的函数引用
    val foo = FunctionReference()
    val m : (String, Long) -> Any = foo::bar

    //解构
    val multi = FunctionReference()
    val (a,b,c) = multi.multiReturnValues()
    //val(a, b, c) = multiReturnValues()
    println("a = $a, b = $b, c = $c")
}

fun multiReturnValues() : Triple<Int, Long, Double> {
    return Triple(1, 3L, 4.0)
}