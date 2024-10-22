package org.keumin.chatservice.adapter.`in`.web.dto

import org.keumin.chatservice.domain.entity.Persona

class PersonaRequest {
    data class Post(
        private val conversationId: String,
        private val age: Int,
        private val role: String,
        private val characteristic: String
    ) {
        fun toEntity() = Persona(
            age = age,
            role = role,
            characteristic = characteristic
        )

        fun getConversationId() = conversationId
    }
}