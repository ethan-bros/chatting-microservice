package org.keumin.chatservice.adapter.out.persistence

import org.keumin.chatservice.domain.entity.Conversation
import org.springframework.data.jpa.repository.JpaRepository

interface JpaConversationRepository : JpaRepository<Conversation, String> {
}