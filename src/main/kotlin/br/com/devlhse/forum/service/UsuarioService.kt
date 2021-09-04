package br.com.devlhse.forum.service

import br.com.devlhse.forum.model.Usuario
import br.com.devlhse.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getById(id)
    }
}
