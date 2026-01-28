package JoseRPrimo.todo.Repository;

import JoseRPrimo.todo.Model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
