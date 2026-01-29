package JoseRPrimo.todo.Controller;

import JoseRPrimo.todo.DTO.TaskRequestDTO;
import JoseRPrimo.todo.DTO.TaskResponseDTO;
import JoseRPrimo.todo.Exception.ResourceNotFoundException;
import JoseRPrimo.todo.Model.TaskModel;
import JoseRPrimo.todo.Service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping("/listar")
    @Operation(summary = "Listar todas as tasks", description = "Essa rota retornará uma lista de todas as tasks adicionadas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Lista nao encontrada.")
    })
    public List<TaskResponseDTO> listarTask(){
        return taskService.listar();
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a task por ID", description = "Essa rota retornará a task na qual seu ID foi digitado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task encontrada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Task nao encontrada.")
    })
    public TaskResponseDTO listarPorId(@Parameter(description = "Usuario manda o id no caminho da requisicao.")@PathVariable Long id) {
        return taskService.listarPorId(id);
    }

    @Operation(summary = "Criar nova task", description = "Rota cria uma nova task e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criacao da task.")
    })
    @PostMapping("/criar")
    public ResponseEntity<TaskResponseDTO> criarTask(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Usuario manda os dados da task a ser atualizada no corpo da requisicao",
            required = true) @Valid @RequestBody TaskRequestDTO task) {
        TaskResponseDTO taskNova = taskService.criar(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskNova);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Altera uma task", description = "Rota altera uma task e insere no banco de dados com valores alterados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task alterada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Task nao encontrada.")
    })
    public TaskResponseDTO atualizarTask(@Parameter(description = "Usuario manda o id no caminho da requisicao.") @PathVariable Long id,
                                         @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                 description = "Usuario manda os dados da task a ser atualizada no corpo da requisicao",
                                                 required = true
                                         ) @RequestBody TaskRequestDTO task) {
        return taskService.atualizar(id, task);
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta uma task", description = "Rota deleta uma task e do banco de dados, buscando por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Task deletada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Task nao encontrada.")
    })
    public ResponseEntity<Void> deletarTask(@Parameter(description = "Usuario manda o id no caminho da requisicao.") @PathVariable Long id) {
        taskService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
