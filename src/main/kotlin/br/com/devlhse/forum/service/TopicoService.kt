package br.com.devlhse.forum.service

import br.com.devlhse.forum.dto.NovoTopicoForm
import br.com.devlhse.forum.dto.TopicoView
import br.com.devlhse.forum.mapper.TopicoFormMapper
import br.com.devlhse.forum.mapper.TopicoViewMapper
import br.com.devlhse.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper,
                    private var topicos: List<Topico> = ArrayList()) {


    fun listar(): List<TopicoView> {
        return topicos.map {
            topicoViewMapper.map(it)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.first { topico ->
            topico.id == id
        }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(novoTopicoForm: NovoTopicoForm) {
        val topico = topicoFormMapper.map(novoTopicoForm)
        topicos = topicos.plus(
            topico.copy(id = topicos.size.toLong() + 1)
        )
    }
}