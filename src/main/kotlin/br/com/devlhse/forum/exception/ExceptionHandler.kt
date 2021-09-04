package br.com.devlhse.forum.exception

import br.com.devlhse.forum.dto.ErrorView
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
            status = NOT_FOUND.value(),
            error = NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }
}