package JoseRPrimo.todo.Exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiErroDTO {

    private Integer status;
    private String erro;
    private String mensagem;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiErroDTO(Integer status, String erro, String mensagem){
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
    }
}
