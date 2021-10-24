package Todo.controller;

import Todo.annotation.Loggable;
import Todo.dto.TaskCreateDto;
import Todo.dto.TaskDto;
import Todo.dto.TaskEditDto;
import Todo.service.TaskService;
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
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Loggable
    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable("id") Integer id) {
        return taskService.getTask(id);
    }

    @Loggable
    @PostMapping
    public TaskDto createTask(@RequestBody TaskCreateDto taskCreateDto) {
        return taskService.createTask(taskCreateDto);
    }

    @Loggable
    @PutMapping("/{id}")
    public TaskDto editTask(@RequestBody TaskEditDto taskEditDto,
                            @PathVariable("id") Integer id) {
        return taskService.editTask(id, taskEditDto);
    }

    @Loggable
    @DeleteMapping("/{id}")
    public List<TaskDto> delete (@PathVariable("id") Integer id){
        return taskService.delete(id);
    }

}
