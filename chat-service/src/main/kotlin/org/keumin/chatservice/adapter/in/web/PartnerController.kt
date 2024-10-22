package org.keumin.chatservice.adapter.`in`.web

import org.keumin.chatservice.adapter.`in`.web.dto.PartnerRequest
import org.keumin.chatservice.domain.service.PartnerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/partner")
class PartnerController(private val partnerService: PartnerService) {
    @PostMapping
    fun createPartner(@RequestBody request: PartnerRequest.Post) {
        partnerService.createPartner(request)
    }
}