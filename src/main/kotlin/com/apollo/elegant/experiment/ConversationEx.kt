package com.apollo.elegant.experiment

import com.apollo.elegant.bean.Conversation
import java.util.*
import java.util.concurrent.ConcurrentMap
import kotlin.collections.ArrayList

class ConversationEx {


}

fun main() {
   val list = ArrayList<Conversation>()
   list.add(Conversation("001", "小明", 1))
   list.add(Conversation("002", "小洪", 4))
   list.add(Conversation("003", "小红", 2))
   list.add(Conversation("004", "小兰", 3))
   list.add(Conversation("004", "小黄", 3))

   val flat = list.associateBy (
      { it.conversationId }, { it }
   ).map {
      it.value
   }.sortedBy {
      it.time
   }.forEach(::println)
//   val conversation = Conversation("005", "凯文", 5);
//   list[4] = conversation
//
//   list.forEach(::println)

}