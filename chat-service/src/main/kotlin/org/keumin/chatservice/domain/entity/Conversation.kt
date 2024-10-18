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
    var id: String,

    var user_id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    var persona: Persona,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    var partner: Partner,

    var purpose: String,

    var relation: String,

    var atmosphere: String,

    ) : BaseTimeEntity() {

    @OneToMany(mappedBy = "conversation", cascade = [CascadeType.ALL], orphanRemoval = true)
    var contents: MutableList<Content> = mutableListOf()
}