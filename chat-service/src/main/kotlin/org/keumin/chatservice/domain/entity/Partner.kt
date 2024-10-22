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
    var id: String? = null,
    var age: Int,
    var role: String,
    var characteristic: String
) : BaseTimeEntity() {
    companion object {
        fun create(age: Int, role: String, characteristic: String) =
            Partner(
                age = age,
                role = role,
                characteristic = characteristic
            )
    }
}