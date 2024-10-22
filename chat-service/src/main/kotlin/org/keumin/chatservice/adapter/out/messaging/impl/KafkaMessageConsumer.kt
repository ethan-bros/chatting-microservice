package org.keumin.chatservice.adapter.out.messaging.impl

import com.fasterxml.jackson.databind.ObjectMapper
import org.keumin.chatservice.adapter.out.messaging.message.ContentSaveMessage
import org.keumin.chatservice.adapter.out.persistence.JpaContentRepository
import org.keumin.chatservice.adapter.out.persistence.JpaConversationRepository
import org.keumin.chatservice.domain.entity.Content
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaMessageConsumer(
    private val objectMapper: ObjectMapper,
    private val contentRepository: JpaContentRepository,
    private val conversationRepository: JpaConversationRepository
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["python-to-kotlin-topic"], groupId = "kotlin-group")
    fun consumeMessage(messageJson: String) {
        try {
            val message = objectMapper.readValue(messageJson, ContentSaveMessage::class.java)
            logger.info("Received message: $message")
            processMessage(
                message.toEntity(
                    conversationRepository.findById(message.conversationId).get()
                )
            )
        } catch (e: Exception) {
            logger.error("Error processing message: ${e.message}")
        }
    }

    fun processMessage(content: Content) {
        contentRepository.save(content)
    }
}