package br.com.devlhse.forum.repository

import br.com.devlhse.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}