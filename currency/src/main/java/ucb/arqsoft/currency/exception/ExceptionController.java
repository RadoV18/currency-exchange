package ucb.arqsoft.currency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ucb.arqsoft.currency.dto.ResponseDto;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDto<Void>> handleIllegalArgumentException(IllegalArgumentException e) {
        ResponseDto<Void> response = new ResponseDto<>();
        response.setSuccessful(false);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
