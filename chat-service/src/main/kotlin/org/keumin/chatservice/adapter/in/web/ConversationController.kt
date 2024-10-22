package org.keumin.chatservice.adapter.`in`.web

import org.keumin.chatservice.adapter.`in`.web.dto.ConversationRequest
import org.keumin.chatservice.domain.service.ConversationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/conversation")
class ConversationController(private val conversationService: ConversationService) {
    @PostMapping
    fun createConversation(@RequestBody request: ConversationRequest.Post) {
        conversationService.createConversation(request)
    }
}