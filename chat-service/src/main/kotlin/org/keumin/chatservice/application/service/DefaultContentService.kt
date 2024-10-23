package org.keumin.chatservice.application.service

import org.keumin.chatservice.adapter.out.persistence.JpaContentRepository
import org.keumin.chatservice.domain.entity.Content
import org.keumin.chatservice.domain.service.ContentService
import org.springframework.stereotype.Service

@Service
class DefaultContentService(private val contentRepository: JpaContentRepository) : ContentService {
    override fun createContent(content: Content) {
        contentRepository.save(content)
    }
}