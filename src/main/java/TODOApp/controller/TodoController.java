package TODOApp.controller;

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

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDto getTask(Integer id) {
        return taskService.getTask(id);
    }

    @PostMapping("/create")
    public List<TaskDto> createTask(@RequestBody TaskCreateDto taskCreateDto) {
        return taskService.createTask(taskCreateDto);
    }

    @PutMapping("/{id}/edit")
    public TaskDto editTask(@RequestBody TaskEditDto taskEditDto,
                            @PathVariable("id") Integer id) {
        return taskService.editTask(id, taskEditDto);
    }

    @DeleteMapping("/{id}/delete")
    public List<TaskDto> delete (Integer id){
        return taskService.delete(id);
    }

}
