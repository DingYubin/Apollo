package com.apollo.elegant.experiment

import com.apollo.elegant.bean.CMCodeCalculation
import com.apollo.elegant.bean.CMLabelCode
import com.apollo.elegant.bean.ITraceCodeItem

class FlatMapEx {

}

fun main() {
    val code1 = ITraceCodeItem("", listOf("xxx", "xxx", "xxx"))
    val code2 = ITraceCodeItem("", listOf("Warner", "Watson", "Smith"))
    val calculation = CMCodeCalculation("001","002","y","222","kkkk", listOf<ITraceCodeItem>(code1, code2),8)
//    val calculation = CMCodeCalculation("001","002","y","222","kkkk", listOf(),8)

//    println(calculation)

    val flat1 = calculation.codes
        .filter { it.singleCodes.isNotEmpty()}
        .flatMap { it.singleCodes}
        .toList()
//    flat1.forEach { print("$it ")}
//    println("========================")
    val res = calculation.copy()
    res.codes = listOf(ITraceCodeItem("", listOf<String>("aoho", "kfc", "lg")))

//    println(res)

//    println(calculation)
    val scanList = arrayListOf<String>("aoho", "kfc", "lg")
    val errorList = arrayListOf<String>("aoho", "lg", "aaa")

    val codeList = scanList.map {
                        CMLabelCode(it, true)
                    }.map {
                        if (errorList.contains(it.labelCode)){
                            it.isValidCode = false
                        }
                        it
                     }.toList()

    println(codeList)


}