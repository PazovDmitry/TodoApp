package Todo.controller;

import Todo.annotation.Loggable;
import Todo.dto.user.UserWithRolesDto;
import Todo.dto.user.filter.UserFilterDto;
import Todo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Loggable
    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{email}/roles")
    public void editRoles(@PathVariable String email,
                          @RequestBody Collection<String> newRoleCodes) {
        Integer userId = userService.getId(email);
        userService.editRole(userId, newRoleCodes);
    }

    @Loggable
    @GetMapping
    public List<UserWithRolesDto> getUsers() {
        return userService.getUsers();
    }

    @Loggable
    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public List<UserWithRolesDto> getUsers(@RequestBody Collection<UserFilterDto> filters) {
        return userService.getUsers(filters);
    }

    @Loggable
    @GetMapping("/{id}")
    public UserWithRolesDto getUser(@PathVariable("id") Integer userId){
        return userService.getUser(userId);
    }

    @Loggable
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public List<UserWithRolesDto> deleteUser(@PathVariable("id") Integer userId){
        return userService.deleteUser(userId);
    }
}