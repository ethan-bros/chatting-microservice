package org.keumin.chatservice.domain.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "ethan_conversations")
@Getter
@Setter
class Conversation(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    val user_id: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    var persona: Persona? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id")
    var partner: Partner? = null,

    val purpose: String,

    val relation: String,

    val atmosphere: String,

    ) : BaseTimeEntity() {

    @OneToMany(mappedBy = "conversation", cascade = [CascadeType.ALL], orphanRemoval = true)
    var contents: MutableList<Content> = mutableListOf()

    companion object {
        fun create(user_id: String, purpose: String, relation: String, atmosphere: String) =
            Conversation(
                user_id = user_id,
                purpose = purpose,
                relation = relation,
                atmosphere = atmosphere
            )
    }
}