package JoseRPrimo.todo.Service;

import JoseRPrimo.todo.DTO.TaskMapper;
import JoseRPrimo.todo.DTO.TaskRequestDTO;
import JoseRPrimo.todo.DTO.TaskResponseDTO;
import JoseRPrimo.todo.Model.TaskModel;
import JoseRPrimo.todo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper mapper;
    public List<TaskResponseDTO> listar(){
        return taskRepository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public Optional<Object> listarPorId(Long id){
        Optional<TaskModel> task = taskRepository.findById(id);
        if (task.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(mapper.toResponse(task.get()));

    }

    public TaskResponseDTO criar(@RequestBody TaskRequestDTO novaTask){
        TaskModel task = mapper.toEntity(novaTask);
        taskRepository.save(task);
        return mapper.toResponse(task);
    }

    public void deletar(Long id){
        if(!taskRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ninja nao existe");
        }
        taskRepository.deleteById(id);
    }

    public TaskResponseDTO atualizar(Long id, TaskRequestDTO taskRequestDTO){
        TaskModel task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task nao encontrada"));
        task.setTitulo(taskRequestDTO.getTitulo());
        task.setDescricao(taskRequestDTO.getDescricao());
        task.setConcluida(taskRequestDTO.getConcluida());
        taskRepository.save(task);
        return mapper.toResponse(task);
    }


}
