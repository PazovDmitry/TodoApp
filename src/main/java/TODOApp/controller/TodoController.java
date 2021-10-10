package TODOApp.controller;

import TODOApp.annotation.Loggable;
import TODOApp.annotation.Loggable2;
import TODOApp.dto.TaskCreateDto;
import TODOApp.dto.TaskDto;
import TODOApp.dto.TaskEditDto;
import TODOApp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {

    private final TaskService taskService;

    public TodoController (TaskService taskService){
        this.taskService = taskService;
    }

    @Loggable
    @Loggable2
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Loggable
    @Loggable2
    @GetMapping("/{id}")
    public TaskDto getTask(Integer id) {
        return taskService.getTask(id);
    }

    @Loggable
    @Loggable2
    @PostMapping("/create")
    public List<TaskDto> createTask(@RequestBody TaskCreateDto taskCreateDto) {
        return taskService.createTask(taskCreateDto);
    }

    @Loggable
    @Loggable2
    @PutMapping("/{id}/edit")
    public TaskDto editTask(@RequestBody TaskEditDto taskEditDto,
                            @PathVariable("id") Integer id) {
        return taskService.editTask(id, taskEditDto);
    }

    @Loggable
    @Loggable2
    @DeleteMapping("/{id}/delete")
    public List<TaskDto> delete (Integer id){
        return taskService.delete(id);
    }

}
