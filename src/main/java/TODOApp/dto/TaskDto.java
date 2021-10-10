package TODOApp.dto;

import lombok.Getter;

@Getter
public class TaskDto {

    private final Integer id;

    private final String name;

    private final Priority priority;

    private final String text;

    public TaskDto(Integer id,
                   String name,
                   Priority priority,
                   String text) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.text = text;
    }

}
