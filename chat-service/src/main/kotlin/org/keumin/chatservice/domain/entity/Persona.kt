package org.keumin.chatservice.domain.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "ethan_personas")
@Getter
@Setter
class Persona(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String,
    var age: Int,
    var role: String,
    var characteristic: String
) : BaseTimeEntity()