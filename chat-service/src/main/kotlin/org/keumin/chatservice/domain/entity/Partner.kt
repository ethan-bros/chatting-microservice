package org.keumin.chatservice.domain.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "ethan_partners")
@Getter
@Setter
class Partner(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String,
    var age: Int,
    var role: String,
    var characteristic: String
) : BaseTimeEntity()