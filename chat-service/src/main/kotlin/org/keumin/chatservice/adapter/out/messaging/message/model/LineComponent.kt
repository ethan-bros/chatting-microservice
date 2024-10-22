package org.keumin.chatservice.adapter.out.messaging.message.model

import org.keumin.chatservice.domain.entity.Content
import org.keumin.chatservice.domain.entity.Line

data class LineComponent(
    val order: Int,
    val speaker: String,
    val line: String,
) {
    companion object {
        fun toEntity(lineComponent: LineComponent, content: Content): Line {
            var line = Line(
                order = lineComponent.order,
                speaker = lineComponent.speaker,
                line = lineComponent.line
            )
            line.content = content
            return line
        }
    }
}