package com.apollo.elegant.bean

import java.io.Serializable

data class Conversation(
    var conversationId: String,
    var conversationName: String,
    var time: Long): Serializable {

    override fun toString(): String {
        return "Conversation(conversationId=$conversationId, conversationName=$conversationName, time=$time)"
    }
}