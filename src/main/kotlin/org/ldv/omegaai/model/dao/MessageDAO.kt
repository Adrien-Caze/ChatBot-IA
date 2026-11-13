package org.ldv.omegaai.model.dao

import org.ldv.omegaai.model.entity.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageDAO : JpaRepository<Message, Long> {
}