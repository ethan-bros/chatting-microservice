package org.keumin.chatservice.domain.service

import org.keumin.chatservice.adapter.`in`.web.dto.ConversationRequest
import org.keumin.chatservice.domain.entity.Conversation

interface ConversationService {
    fun createConversation(request: ConversationRequest.Post)
    fun getConversation(id: String): Conversation
    fun updateConversation()
    fun deleteConversation()
}