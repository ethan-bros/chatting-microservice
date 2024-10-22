package org.keumin.chatservice.domain.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "ethan_lines")
@Getter
@Setter
class Line(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @Column(name = "line_order")
    val order: Int,
    val speaker: String,
    val line: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    var content: Content? = null
) : BaseTimeEntity() {
}