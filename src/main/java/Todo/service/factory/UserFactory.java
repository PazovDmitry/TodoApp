package Todo.service.factory;

import Todo.entity.Role;
import Todo.entity.User;

import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class UserFactory {

    public User build(String firstName, String lastName, String email, String password, Set<Role> roles) {
        return new User(firstName, lastName, email, password, roles);
    }
}
