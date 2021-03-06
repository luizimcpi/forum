package br.com.devlhse.forum.repository

import br.com.devlhse.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String, pageable: Pageable): Page<Topico>

    @Query("select t from Topico t where t.respostas is empty")
    fun topicosNaoRespondidos(): List<Topico>
}