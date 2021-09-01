package br.com.devlhse.forum.service

import br.com.devlhse.forum.dto.NovoTopicoDto
import br.com.devlhse.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private val cursoService: CursoService,
                    private val usuarioService: UsuarioService,
                    private var topicos: List<Topico> = ArrayList()) {


    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.first { topico ->
            topico.id == id
        }
    }

    fun cadastrar(topicoDto: NovoTopicoDto) {
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