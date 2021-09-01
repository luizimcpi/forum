package br.com.devlhse.forum.service

import br.com.devlhse.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {
    init{
        val usuario = Usuario(id = 1, nome = "Ana Developr", email = "ana@email.com")
        usuarios = listOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.first{
            it.id == id
        }
    }
}
