package org.keumin.chatservice.domain.service

import org.keumin.chatservice.adapter.`in`.web.dto.PartnerRequest

interface PartnerService {
    fun createPartner(request: PartnerRequest.Post)
    fun getPartner()
    fun updatePartner()
    fun deletePartner()
}