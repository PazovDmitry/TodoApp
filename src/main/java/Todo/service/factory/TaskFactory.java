package Todo.service.factory;

import Todo.dto.Priority;
import Todo.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {

    public Task build(String title, String text, Priority priority, Integer creatorId) {
        return new Task(title, text, priority, creatorId);
    }
}
