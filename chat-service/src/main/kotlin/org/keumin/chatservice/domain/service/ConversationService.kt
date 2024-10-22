package org.keumin.chatservice.domain.service

import org.keumin.chatservice.adapter.`in`.web.dto.ConversationRequest

interface ConversationService {
    fun createConversation(request: ConversationRequest.Post)
    fun getConversation()
    fun updateConversation()
    fun deleteConversation()
}