package TODOApp.service;


import TODOApp.dto.TaskCreateDto;
import TODOApp.dto.TaskDto;
import TODOApp.dto.TaskEditDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();

    TaskDto getTask(Integer id);

    List<TaskDto> createTask(TaskCreateDto taskCreateDto);

    TaskDto editTask(Integer id, TaskEditDto taskEditDto);

    List<TaskDto> delete (Integer id);
}
