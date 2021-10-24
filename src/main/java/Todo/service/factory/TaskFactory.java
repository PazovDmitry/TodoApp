package Todo.service.factory;

import Todo.entity.Role;
import Todo.enums.Priority;
import Todo.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class TaskFactory {

    public Task build(String title, String text, Priority priority, Integer creatorId) {
        return new Task(title, text, priority, creatorId);
    }
}
