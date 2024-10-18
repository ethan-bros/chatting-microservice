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
    var id: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id")
    var conversation: Conversation,

    ) : BaseTimeEntity() {
    @OneToMany(mappedBy = "content", cascade = [CascadeType.ALL], orphanRemoval = true)
    var lines: MutableList<Line> = mutableListOf()
}