package Todo.dto.user;

import Todo.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class UserCreateDto {

    private final String firstName;

    private final String lastName;

    private final String email;

    private final String password;

    public UserCreateDto(@JsonProperty("firstName") String firstName,
                         @JsonProperty("lastName") String lastName,
                         @JsonProperty("email") String email,
                         @JsonProperty("password") String password
                         ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}