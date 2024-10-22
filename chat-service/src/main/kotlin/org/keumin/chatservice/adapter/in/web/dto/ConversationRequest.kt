package org.keumin.chatservice.adapter.`in`.web.dto

import jakarta.validation.constraints.NotBlank
import org.keumin.chatservice.domain.entity.Conversation

sealed class ConversationRequest {
    data class Post(
        @field:NotBlank(message = "유저 아이디는 필수입니다.")
        val userId: String,
        @field:NotBlank(message = "대화 목적은 필수입니다.")
        val purpose: String,
        @field:NotBlank(message = "관계는 필수입니다.")
        val relation: String,
        @field:NotBlank(message = "대화 분위기는 필수입니다.")
        val atmosphere: String
    ) : ConversationRequest() {
        fun toEntity(): Conversation {
            return Conversation(
                user_id = userId,
                purpose = purpose,
                relation = relation,
                atmosphere = atmosphere
            )
        }
    }
}