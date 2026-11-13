package org.ldv.omegaai.model.dao

import org.ldv.omegaai.model.entity.FournisseurIA
import org.springframework.data.jpa.repository.JpaRepository

interface FournisseurIADAO : JpaRepository<FournisseurIA, Long> {
}