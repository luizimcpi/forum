package br.com.devlhse.forum.service

import br.com.devlhse.forum.dto.AtualizacaoTopicoForm
import br.com.devlhse.forum.dto.NovoTopicoForm
import br.com.devlhse.forum.dto.TopicoView
import br.com.devlhse.forum.exception.NotFoundException
import br.com.devlhse.forum.mapper.TopicoFormMapper
import br.com.devlhse.forum.mapper.TopicoViewMapper
import br.com.devlhse.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class TopicoService(private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper,
                    private val repository: TopicoRepository,
                    private val notFoundMessage: String = "Tópico não encontrado!",
                    private val entityManager: EntityManager
) {


    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if(nomeCurso == null){
            print(entityManager)
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }

        return topicos.map {
            topicoViewMapper.map(it)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{ NotFoundException(notFoundMessage) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(novoTopicoForm: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(novoTopicoForm)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{ NotFoundException(notFoundMessage) }

        val topicoAtualizado = topico.copy(titulo = form.titulo, mensagem = form.mensagem)

        repository.save(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun relatorio(): List<TopicoView> {
        val topicosNaoRespondidos = repository.topicosNaoRespondidos()
        return topicosNaoRespondidos.map {
            topicoViewMapper.map(it)
        }
    }
}