package org.ldv.omegaai.model.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class ModeleIA(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    var nom: String,
    var description: String,
    var urlAPI: String,
    var cheminLogo: String,

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    var fourniseur: FournisseurIA? = null,

    @OneToMany(mappedBy = "modele")
    var conversations: MutableList<Conversation> = mutableListOf()
)