package JoseRPrimo.todo.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TaskResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean concluida;
    private LocalDate dataCriacao;
}
