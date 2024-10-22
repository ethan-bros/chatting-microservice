package org.keumin.chatservice.adapter.out.persistence

import org.keumin.chatservice.domain.entity.Persona
import org.springframework.data.jpa.repository.JpaRepository

interface JpaPersonaRepository : JpaRepository<Persona, String> {
}