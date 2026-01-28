package JoseRPrimo.todo.Controller;

import JoseRPrimo.todo.DTO.TaskRequestDTO;
import JoseRPrimo.todo.DTO.TaskResponseDTO;
import JoseRPrimo.todo.Exception.ResourceNotFoundException;
import JoseRPrimo.todo.Model.TaskModel;
import JoseRPrimo.todo.Service.TaskService;
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
@RequestMapping
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/listar")
    public List<TaskResponseDTO> listarTask(){
        return taskService.listar();
    }

    @GetMapping("/listar/{id}")
    public Optional<Object> listarPorId(@PathVariable Long id){
        return taskService.listarPorId(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<TaskResponseDTO> criarTask(@Valid @RequestBody TaskRequestDTO task){
        TaskResponseDTO taskNova = taskService.criar(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskNova);
    }

    @PutMapping("/atualizar/{id}")
    public TaskResponseDTO atualizarTask(@PathVariable Long id, @RequestBody TaskRequestDTO task){
        return taskService.atualizar(id, task);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTask(@PathVariable Long id){
        taskService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
