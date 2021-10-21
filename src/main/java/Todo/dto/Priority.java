package Todo.dto;

import lombok.Getter;

@Getter
public enum Priority {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");

    private final String priority;

    Priority(String priority) {
        this.priority = priority;
    }

}
