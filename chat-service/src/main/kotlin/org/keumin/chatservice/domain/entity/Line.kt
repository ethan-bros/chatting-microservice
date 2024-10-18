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
    var id: String,

    @Column(name = "line_order")
    var order: Int,
    var speaker: String,
    var line: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    var content: Content
) : BaseTimeEntity() {
}