package org.keumin.chatservice.domain.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "ethan_contents")
@Getter
@Setter
class Content(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id")
    val conversation: Conversation,
    @OneToMany(mappedBy = "content", cascade = [CascadeType.ALL], orphanRemoval = true)
    val lines: MutableList<Line> = mutableListOf()
) : BaseTimeEntity()