package JoseRPrimo.todo.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Schema(description = "Dados retornados pelo sistema para leitura", accessMode = Schema.AccessMode.READ_ONLY)
public class TaskResponseDTO {
    @Schema(description = "ID da task", example = "1")
    private Long id;
    @Schema(description = "Título da task", example = "Regar as plantas")
    private String titulo;
    @Schema(description = "Descrição da task", example = "Regar todas as plantas do quintal")
    private String descricao;
    @Schema(description = "Informa se a task foi ou não concluída")
    private Boolean concluida;
    @Schema(description = "Data de criação da task", example = "2024-01-30", type = "string", format = "date")
    private LocalDate dataCriacao;
}
