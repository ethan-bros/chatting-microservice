package org.keumin.chatservice.application.service

import org.keumin.chatservice.adapter.`in`.web.dto.PersonaRequest
import org.keumin.chatservice.adapter.out.persistence.JpaConversationRepository
import org.keumin.chatservice.adapter.out.persistence.JpaPersonaRepository
import org.keumin.chatservice.domain.service.PersonaService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DefaultPersonaService(
    private val personaRepository: JpaPersonaRepository,
    private val conversationRepository: JpaConversationRepository
) :
    PersonaService {
    override fun createPersona(request: PersonaRequest.Post) {
        var persona = request.toEntity()
        var conversation =
            conversationRepository.findById(request.getConversationId()).orElseThrow()
        conversation.persona = persona
        conversationRepository.save(conversation)
        personaRepository.save(persona)
    }
}