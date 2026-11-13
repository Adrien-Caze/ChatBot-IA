package org.ldv.omegaai.model.dao

import org.ldv.omegaai.model.entity.Conversation
import org.springframework.data.jpa.repository.JpaRepository

interface ConversationDAO : JpaRepository<Conversation, Long> {
}