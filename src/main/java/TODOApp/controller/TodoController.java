package TODOApp.controller;


import TODOApp.dto.Priority;
import TODOApp.dto.TaskCreateDto;
import TODOApp.dto.TaskDto;
import TODOApp.dto.TaskEditDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {

    private List<TaskDto> tasks = new ArrayList<>();
    private Integer tasksCount = 0;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return tasks;
    }

    @GetMapping("/{id}")
    public TaskDto getTask(Integer id) {
        return tasks.stream().filter(task -> task.getId() == id).findAny().orElse(null);
    }

    @PostMapping("/create")
    public List<TaskDto> createTask(@RequestBody TaskCreateDto taskCreateDto) {

        TaskDto taskDto = new TaskDto(
                ++tasksCount,
                taskCreateDto.getName(),
                taskCreateDto.getPriority(),
                taskCreateDto.getText()
        );
        tasks.add(taskDto);
        return tasks;
    }

    @PutMapping("/{id}/edit")
    public TaskDto editTask(@RequestBody TaskEditDto taskEditDto,
                            @PathVariable("id") Integer id) {

        TaskDto taskToBeUpdated = getTask(id);

        taskToBeUpdated.setName(taskEditDto.getName());
        taskToBeUpdated.setPriority(taskEditDto.getPriority());
        taskToBeUpdated.setText(taskEditDto.getText());
        return taskToBeUpdated;
    }

    @DeleteMapping("/{id}/delete")
    public List<TaskDto> delete (Integer id){
        tasks.removeIf(p -> p.getId() == id);
        return tasks;
    }

}
