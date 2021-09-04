package br.com.devlhse.forum.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity
data class Usuario (
        @Id @GeneratedValue(strategy = IDENTITY)
        val id: Long?,
        val nome: String,
        val email: String
)


