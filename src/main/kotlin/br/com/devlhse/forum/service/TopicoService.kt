package br.com.devlhse.forum.service

import br.com.devlhse.forum.model.Curso
import br.com.devlhse.forum.model.Topico
import br.com.devlhse.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
                id = 1,
                titulo = "Duvida Kotlin",
                mensagem = "Variaveis no kotlin",
                curso = Curso(
                        id = 1,
                        nome = "Kotlin",
                        categoria = "Programação"
                ),
                autor = Usuario(
                        id = 1,
                        nome = "Ana da Silva",
                        email = "ana@email.com"
                )
        )
        val topico2 = Topico(
                id = 2,
                titulo = "Duvida Kotlin",
                mensagem = "Variaveis no kotlin",
                curso = Curso(
                        id = 1,
                        nome = "Kotlin",
                        categoria = "Programação"
                ),
                autor = Usuario(
                        id = 1,
                        nome = "Ana da Silva",
                        email = "ana@email.com"
                )
        )
        val topico3 = Topico(
                id = 3,
                titulo = "Duvida Kotlin",
                mensagem = "Variaveis no kotlin",
                curso = Curso(
                        id = 1,
                        nome = "Kotlin",
                        categoria = "Programação"
                ),
                autor = Usuario(
                        id = 1,
                        nome = "Ana da Silva",
                        email = "ana@email.com"
                )
        )
        topicos = listOf(topico, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }
}