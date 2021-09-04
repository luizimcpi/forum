package br.com.devlhse.forum.exception

class NotFoundException(override val message: String?): RuntimeException(message) {
}