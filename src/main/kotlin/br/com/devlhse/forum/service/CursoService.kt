package br.com.devlhse.forum.service

import br.com.devlhse.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(var cursos: List<Curso>) {

    init{
        val cursoKotlin = Curso(id = 1, nome = "kotlin", categoria = "Programação")
        cursos = listOf(cursoKotlin)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.first{
            it.id == id
        }
    }
}
