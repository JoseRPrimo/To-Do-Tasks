package JoseRPrimo.todo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {
    @NotBlank(message = "Titulo Obrigatorio")
    private String titulo;
    private String descricao;
    private Boolean concluida;
}
