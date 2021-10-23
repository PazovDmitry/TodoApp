package Todo.service;

import Todo.dto.user.UserWithRolesDto;
import Todo.dto.user.filter.UserFilterDto;

import java.util.Collection;
import java.util.List;

public interface UserService {

    Integer getId(String email);

    void editRole(Integer userId, Collection<String> roleCodes);

    List<UserWithRolesDto> getUsers();

    UserWithRolesDto getUser(Integer userId);

    List<UserWithRolesDto> deleteUser(Integer userId);

    List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters);


}
