package JoseRPrimo.todo.DTO;

import JoseRPrimo.todo.Model.TaskModel;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskModel toEntity(TaskRequestDTO taskDTO) {
        TaskModel task = new TaskModel();
        task.setTitulo(taskDTO.getTitulo());
        task.setDescricao(taskDTO.getDescricao());
        task.setConcluida(taskDTO.getConcluida());
        return task;
    }

    public TaskResponseDTO toResponse(TaskModel taskModel){
        return new TaskResponseDTO(
            taskModel.getId(),
            taskModel.getTitulo(),
            taskModel.getDescricao(),
            taskModel.getConcluida(),
            taskModel.getDataCriacao());
    }
}
