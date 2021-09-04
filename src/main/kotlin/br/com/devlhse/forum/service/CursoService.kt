package br.com.devlhse.forum.service

import br.com.devlhse.forum.model.Curso
import br.com.devlhse.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getById(id)
    }
}
