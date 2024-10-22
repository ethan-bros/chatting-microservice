package org.keumin.chatservice.adapter.out.messaging

interface MessageProducer {
    fun sendMessage(topic: String, message: String)
}