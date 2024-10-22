package org.keumin.chatservice.adapter.`in`.web

import org.keumin.chatservice.adapter.`in`.web.dto.PersonaRequest
import org.keumin.chatservice.domain.service.PersonaService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/persona")
class PersonaController(private val personaService: PersonaService) {
    @PostMapping
    fun createPersona(@RequestBody request: PersonaRequest.Post) {
        personaService.createPersona(request)
    }
}