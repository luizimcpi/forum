package br.com.devlhse.forum.mapper

import br.com.devlhse.forum.dto.NovoTopicoForm
import br.com.devlhse.forum.model.Topico
import br.com.devlhse.forum.service.CursoService
import br.com.devlhse.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(private val cursoService: CursoService,
                       private val usuarioService: UsuarioService): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
                titulo = t.titulo,
                mensagem = t.mensagem,
                curso = cursoService.buscarPorId(t.idCurso),
                autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
