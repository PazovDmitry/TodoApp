package TODOApp.dto;

import lombok.Getter;

@Getter
public class TaskDto {

    private final Integer id;

    private String name;

    private Priority priority;

    private String text;

    public TaskDto(Integer id,
                   String name,
                   Priority priority,
                   String text) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) { this.priority = priority; }

    public void setText(String text) {
        this.text = text;
    }
}
