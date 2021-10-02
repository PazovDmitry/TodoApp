package TODOApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TaskCreateDto {

    private final String name;

    private final String text;

    public TaskCreateDto(@JsonProperty("name") String name,
                         @JsonProperty("text") String text) {
        this.name = name;
        this.text = text;
    }
}
