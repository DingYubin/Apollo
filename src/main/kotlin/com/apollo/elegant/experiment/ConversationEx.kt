package com.apollo.elegant.experiment

import com.apollo.elegant.bean.Conversation
import com.google.gson.Gson
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.stream.Collectors

class ConversationEx {


}

fun main() {
    val list = ArrayList<Conversation>()
    val maxList = ArrayList<ArrayList<Conversation>>()
    list.add(Conversation("001", "小明", 1))
    list.add(Conversation("002", "小洪", 4))
    list.add(Conversation("003", "小红", 2))
    maxList.add(list)

    maxList.forEach(::println)
    maxList.filter {
        it.isNotEmpty()
    }.flatten().forEach {
        it.time = 0
    }
    maxList.forEach(::println)


    println("==============================================")
    println("==============================================")

//    list.stream().map {
//        it.conversationName
//    }.collect(Collectors.toList())
//        .forEach(::println)
//    list.find {
//        it.conversationId == "002"
//    }.let {
//        it?.conversationName = "lele"
//        it?.time = 10
//    }

//    list.filter { it.conversationId == "003" }.forEach { it.time = 0 }
//
//    list.forEach(::println)
//
//    println("==============================================")
//    println("==============================================")
//
//    val kk = deepClone(list)
//    kk?.associateBy(
//        { it.conversationId }, { it }
//    )?.map {
//        it.value
//    }?.sortedBy {
//        it.time
//    }?.forEach(::println)
//
//    println("==============================================")
//    list.add(Conversation("004", "小兰", 3))
//    list.add(Conversation("005", "小黄", 3))
//
//    kk?.associateBy(
//        { it.conversationId }, { it }
//    )?.map {
//        it.value
//    }?.sortedBy {
//        it.time
//    }?.forEach(::println)
//
//    println("==============================================")
//    list?.associateBy(
//        { it.conversationId }, { it }
//    )?.map {
//        it.value
//    }?.sortedBy {
//        it.time
//    }?.forEach(::println)

//   val conversation = Conversation("005", "凯文", 5);
//   list[4] = conversation
//
//   list.forEach(::println)

}

//inline fun <reified T> deepClone(data: T): T {
//    return Gson().fromJson(Gson().toJson(data), T::class.java)
//}

fun <E> deepClone(src: List<E>?): List<E>? {
    return try {
        val byteOut = ByteArrayOutputStream()
        val out = ObjectOutputStream(byteOut)
        out.writeObject(src)
        val byteIn = ByteArrayInputStream(byteOut.toByteArray())
        val `in` = ObjectInputStream(byteIn)
        `in`.readObject() as List<E>
    } catch (e: Exception) {
        e.printStackTrace()
        ArrayList()
    }
}

//fun <T : Any> T.deepCopy(): T {
//   //如果不是数据类，直接返回
//   if (!this::class.isData) {
//      return this
//   }
//
//   //拿到构造函数
//   return this::class.primaryConstructor!!.let {
//         primaryConstructor ->
//      primaryConstructor.parameters.map { parameter ->
//         //转换类型
//         //memberProperties 返回非扩展属性中的第一个并将构造函数赋值给其
//         //最终value=第一个参数类型的对象
//         val value = (this::class as KClass<T>).memberProperties.first {
//            it.name == parameter.name
//         }.get(this)
//
//         //如果当前类(这里的当前类指的是参数对应的类型，比如说这里如果非基本类型时)是数据类
//         if ((parameter.type.classifier as? KClass<*>)?.isData == true) {
//            parameter to value?.deepCopy()
//         } else {
//            parameter to value
//         }
//
//
//         //最终返回一个新的映射map,即返回一个属性值重新组合的map，并调用callBy返回指定的对象
//      }.toMap().let(primaryConstructor::callBy)
//   }
//}
