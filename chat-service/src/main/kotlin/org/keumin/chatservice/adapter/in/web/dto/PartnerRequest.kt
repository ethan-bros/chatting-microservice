package org.keumin.chatservice.adapter.`in`.web.dto

import org.keumin.chatservice.domain.entity.Partner

class PartnerRequest {
    data class Post(
        private val conversationId: String,
        private val age: Int,
        private val role: String,
        private val characteristic: String
    ) {
        fun toEntity() = Partner(
            age = age,
            role = role,
            characteristic = characteristic
        )

        fun getConversationId() = conversationId
    }
}