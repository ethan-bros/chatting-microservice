package org.keumin.chatservice.domain.service

import org.keumin.chatservice.domain.entity.Content

interface ContentService {
    fun createContent(content: Content)
}