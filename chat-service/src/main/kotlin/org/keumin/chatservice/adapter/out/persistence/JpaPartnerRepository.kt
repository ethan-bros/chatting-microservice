package org.keumin.chatservice.adapter.out.persistence

import org.keumin.chatservice.domain.entity.Partner
import org.springframework.data.jpa.repository.JpaRepository

interface JpaPartnerRepository : JpaRepository<Partner, String> {
}