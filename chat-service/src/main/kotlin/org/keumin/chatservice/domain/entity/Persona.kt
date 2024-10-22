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
    val id: String? = null,
    val age: Int,
    val role: String,
    val characteristic: String
) : BaseTimeEntity() {

    companion object {
        fun create(age: Int, role: String, characteristic: String) =
            Persona(
                age = age,
                role = role,
                characteristic = characteristic
            )
    }
}