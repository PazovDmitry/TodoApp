package TODOApp.dto;

import lombok.Getter;

@Getter
public class TaskDto {

    private final Integer id;

    private String name;

    private String text;

    public TaskDto(Integer id,
                   String name,
                   String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }


}
