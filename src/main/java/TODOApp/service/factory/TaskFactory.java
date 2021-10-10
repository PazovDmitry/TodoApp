package TODOApp.service.factory;

import TODOApp.dto.Priority;
import TODOApp.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {

    public Task build(String title, String text, Priority priority, Integer creatorId) {
        return new Task(title, text, priority, creatorId);
    }
}
