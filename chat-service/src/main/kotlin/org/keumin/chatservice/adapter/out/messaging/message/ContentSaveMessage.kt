package org.keumin.chatservice.adapter.out.messaging.message

import org.keumin.chatservice.adapter.out.messaging.message.model.LineComponent
import org.keumin.chatservice.domain.entity.Content
import org.keumin.chatservice.domain.entity.Conversation

data class ContentSaveMessage(
    val conversationId: String,
    val lines: MutableList<LineComponent>
) {
    fun toEntity(conversation: Conversation): Content {
        var content = Content(
            conversation = conversation,
        )
        val lines = lines.map { LineComponent.toEntity(it, content) }
        content.lines.addAll(lines)
        return content
    }
}