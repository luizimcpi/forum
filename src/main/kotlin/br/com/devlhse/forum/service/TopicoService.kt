package br.com.devlhse.forum.service

import br.com.devlhse.forum.dto.AtualizacaoTopicoForm
import br.com.devlhse.forum.dto.NovoTopicoForm
import br.com.devlhse.forum.dto.TopicoView
import br.com.devlhse.forum.exception.NotFoundException
import br.com.devlhse.forum.mapper.TopicoFormMapper
import br.com.devlhse.forum.mapper.TopicoViewMapper
import br.com.devlhse.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper,
                    private var topicos: List<Topico> = ArrayList(),
                    private val notFoundMessage: String = "Tópico não encontrado!"
) {


    fun listar(): List<TopicoView> {
        return topicos.map {
            topicoViewMapper.map(it)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.firstOrNull { topico ->
            topico.id == id
        } ?: throw NotFoundException(notFoundMessage)

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(novoTopicoForm: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(novoTopicoForm)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.firstOrNull { topico ->
            topico.id == form.id
        } ?: throw NotFoundException(notFoundMessage)

        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao,
            )
        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.firstOrNull { topico ->
            topico.id == id
        } ?: throw NotFoundException(notFoundMessage)
        topicos = topicos.minus(topico)
    }
}