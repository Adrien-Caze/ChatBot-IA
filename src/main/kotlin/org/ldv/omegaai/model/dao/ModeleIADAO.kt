package org.ldv.omegaai.model.dao

import org.ldv.omegaai.model.entity.ModeleIA
import org.springframework.data.jpa.repository.JpaRepository

interface ModeleIADAO : JpaRepository<ModeleIA, Long> {
}