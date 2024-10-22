package org.keumin.chatservice.application.service

import org.keumin.chatservice.adapter.`in`.web.dto.PartnerRequest
import org.keumin.chatservice.adapter.out.persistence.JpaConversationRepository
import org.keumin.chatservice.adapter.out.persistence.JpaPartnerRepository
import org.keumin.chatservice.domain.service.PartnerService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DefaultPartnerService(
    private val partnerRepository: JpaPartnerRepository,
    private val conversationRepository: JpaConversationRepository
) : PartnerService {
    override fun createPartner(request: PartnerRequest.Post) {
        var partner = request.toEntity()
        var conversation =
            conversationRepository.findById(request.getConversationId()).orElseThrow()
        conversation.partner = partner
        conversationRepository.save(conversation)
        partnerRepository.save(partner)
    }

    override fun getPartner() {
        TODO("Not yet implemented")
    }

    override fun updatePartner() {
        TODO("Not yet implemented")
    }

    override fun deletePartner() {
        TODO("Not yet implemented")
    }
}