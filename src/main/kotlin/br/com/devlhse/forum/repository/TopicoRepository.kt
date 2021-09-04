package br.com.devlhse.forum.repository

import br.com.devlhse.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}