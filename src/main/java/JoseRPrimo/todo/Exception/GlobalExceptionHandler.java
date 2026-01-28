package JoseRPrimo.todo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErroDTO> handleNotFound(ResourceNotFoundException exception){

        ApiErroDTO erroDTO = new ApiErroDTO(HttpStatus.NOT_FOUND.value(),"Recurso nao encontrado", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
    }

}
