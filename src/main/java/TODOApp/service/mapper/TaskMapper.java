package TODOApp.service.mapper;

import TODOApp.dto.TaskDto;
import TODOApp.entity.Task;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskDto mapTaskToTaskDto (Task model){
        return new TaskDto(
                model.getId(),
                model.getTitle(),
                model.getPriority(),
                model.getText());
    }

    public List<TaskDto> mapTaskToTaskDto(Collection<Task> model){
        return model.stream().map(this::mapTaskToTaskDto).collect(Collectors.toList());
    }
}
