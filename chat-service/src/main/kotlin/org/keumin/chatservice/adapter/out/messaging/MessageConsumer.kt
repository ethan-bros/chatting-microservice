package org.keumin.chatservice.adapter.out.messaging

interface MessageConsumer {
    fun consumeMessage(message: String)
}