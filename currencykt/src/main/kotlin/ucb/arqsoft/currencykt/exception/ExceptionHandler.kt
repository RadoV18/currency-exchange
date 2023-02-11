package ucb.arqsoft.currencykt.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import ucb.arqsoft.currencykt.dto.ResponseDto

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<ResponseDto<Any?>> {
        return ResponseEntity<ResponseDto<Any?>>(
            ResponseDto<Any?>(
                data = null,
                message = e.message ?: "Bad Request",
                successful = false
            ),
            HttpStatus.BAD_REQUEST
        );
    }
}