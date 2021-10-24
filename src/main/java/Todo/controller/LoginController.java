package Todo.controller;

import Todo.dto.user.UserCreateDto;
import Todo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String registration(@RequestBody UserCreateDto userCreateDto) {
        userService.createUser(userCreateDto);
        return "Registration is successful";
    }
}
