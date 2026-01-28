package JoseRPrimo.todo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {
    private String titulo;
    private String descricao;
    private Boolean concluida;
}
