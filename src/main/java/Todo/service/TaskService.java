package Todo.service;


import Todo.dto.TaskCreateDto;
import Todo.dto.TaskDto;
import Todo.dto.TaskEditDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();

    TaskDto getTask(Integer id);

    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto editTask(Integer id, TaskEditDto taskEditDto);

    List<TaskDto> delete (Integer id);
}
