package org.ldv.omegaai.model.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class Conversation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    var titre: String,                       // ex-"contenu" : le contenu est dans les messages
    var dateCreation: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "modele_id")
    var modele: ModeleIA? = null,

    @OneToMany(mappedBy = "conversation", cascade = [CascadeType.ALL], orphanRemoval = true)
    var messages: MutableList<Message> = mutableListOf()
)