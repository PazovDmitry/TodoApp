package TODOApp.service.impl;

import TODOApp.dto.TaskCreateDto;
import TODOApp.dto.TaskDto;
import TODOApp.dto.TaskEditDto;
import TODOApp.entity.Task;
import TODOApp.repository.TaskRepository;
import TODOApp.repository.UserRepository;
import TODOApp.service.TaskService;
import TODOApp.service.context.UserContext;
import TODOApp.service.factory.TaskFactory;
import TODOApp.service.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaTaskService implements TaskService {

    private final UserContext userContext;

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;
    private final TaskFactory taskFactory;

    public JpaTaskService(UserContext userContext,
                          TaskRepository taskRepository,
                          UserRepository userRepository,
                          TaskMapper taskMapper,
                          TaskFactory taskFactory){
        this.userContext = userContext;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskMapper = taskMapper;
        this.taskFactory = taskFactory;
    }

    @Override
    public List<TaskDto> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.mapTaskToTaskDto(tasks);
    }

    @Override
    public TaskDto getTask(Integer id){
        Task task = taskRepository.findById(id).orElseThrow();
        return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public List<TaskDto> createTask(TaskCreateDto taskCreateDto){

        String email = userContext.getEmail();
        Integer userId = userRepository.findByEmail(email).orElseThrow().getId();

        Task task = taskFactory.build(
                taskCreateDto.getName(),
                taskCreateDto.getText(),
                taskCreateDto.getPriority(),
                userId
        );
        taskRepository.saveAndFlush(task);

        return getAllTasks();
    }

    @Override
    public TaskDto editTask (Integer taskId, TaskEditDto taskEditDto){
        Task task = taskRepository.findById(taskId).orElseThrow();

        task.setTitle(taskEditDto.getName());
        task.setPriority(taskEditDto.getPriority());
        task.setText(taskEditDto.getText());

        taskRepository.saveAndFlush(task);

        return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public List<TaskDto> delete (Integer id){

        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);

        return getAllTasks();
    }

}
