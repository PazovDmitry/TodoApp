package Todo.service;


import Todo.dto.task.TaskCreateDto;
import Todo.dto.task.TaskDto;
import Todo.dto.task.TaskEditDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();

    TaskDto getTask(Integer id);

    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto editTask(Integer id, TaskEditDto taskEditDto);

    List<TaskDto> delete (Integer id);
}
