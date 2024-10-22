package org.keumin.chatservice.domain.service

import org.keumin.chatservice.adapter.`in`.web.dto.PersonaRequest

interface PersonaService {
    fun createPersona(request: PersonaRequest.Post)
}