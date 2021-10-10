package TODOApp.dto;

import lombok.Getter;

@Getter
public enum Priority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private String priority;

    Priority(String priority) {
        this.priority = priority;
    }

}
