package org.keumin.chatservice.adapter.out.persistence

import org.keumin.chatservice.domain.entity.Content
import org.springframework.data.jpa.repository.JpaRepository

interface JpaContentRepository : JpaRepository<Content, String> {
}