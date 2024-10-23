package org.keumin.chatservice.application.service

import org.keumin.chatservice.adapter.`in`.web.dto.ConversationRequest
import org.keumin.chatservice.adapter.out.persistence.JpaConversationRepository
import org.keumin.chatservice.domain.entity.Conversation
import org.keumin.chatservice.domain.service.ConversationService
import org.springframework.stereotype.Service

@Service
class DefaultConversationService(private val conversationRepository: JpaConversationRepository) :
    ConversationService {
    override fun createConversation(request: ConversationRequest.Post) {
        conversationRepository.save(request.toEntity())
    }

    override fun getConversation(id: String): Conversation {
        return conversationRepository.findById(id).orElseThrow()
    }

    override fun updateConversation() {
        TODO("Not yet implemented")
    }

    override fun deleteConversation() {
        TODO("Not yet implemented")
    }
}