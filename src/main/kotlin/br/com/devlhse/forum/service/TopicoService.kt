package br.com.devlhse.forum.service

import br.com.devlhse.forum.dto.NovoTopicoForm
import br.com.devlhse.forum.dto.TopicoView
import br.com.devlhse.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private val cursoService: CursoService,
                    private val usuarioService: UsuarioService,
                    private var topicos: List<Topico> = ArrayList()) {


    fun listar(): List<TopicoView> {
        return topicos.map {
            TopicoView(
                    id = it.id!!,
                    titulo = it.titulo,
                    mensagem = it.mensagem,
                    status = it.status,
                    dataCriacao = it.dataCriacao
            )
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.first { topico ->
            topico.id == id
        }

        return TopicoView(
                id = topico.id!!,
                titulo = topico.titulo,
                mensagem = topico.mensagem,
                status = topico.status,
                dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(topicoDto: NovoTopicoForm) {
        topicos = topicos.plus(
                Topico(
                        id = topicos.size.toLong() + 1,
                        titulo = topicoDto.titulo,
                        mensagem = topicoDto.mensagem,
                        curso = cursoService.buscarPorId(topicoDto.idCurso),
                        autor = usuarioService.buscarPorId(topicoDto.idAutor)
                )
        )
    }
}