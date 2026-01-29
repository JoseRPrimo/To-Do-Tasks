package JoseRPrimo.todo.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados para criação ou atualização de uma task")
public class TaskRequestDTO {
    @NotBlank(message = "Titulo Obrigatorio")
    @Schema(description = "Titulo da task", example = "Regar as plantas")
    private String titulo;
    @Schema(description = "Descricao da task", example = "Regar todas as plantas do quintal")
    private String descricao;
    @Schema(description = "Informa se a task foi ou não concluida", example = "true")
    private Boolean concluida;
}
