package br.com.devlhse.forum.service

import br.com.devlhse.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList()) {


    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.first { topico ->
            topico.id == id
        }
    }

    fun cadastrar(topico: Topico) {
        topicos.plus(topico)
    }
}