package Todo.service;

import Todo.dto.authentication.UserAuthenticationInfoDto;
import Todo.dto.user.UserCreateDto;
import Todo.dto.user.UserWithRolesDto;
import Todo.dto.user.filter.UserFilterDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Integer getId(String email);

    void editRole(Integer userId, Collection<String> roleCodes);

    List<UserWithRolesDto> getUsers();

    UserWithRolesDto getUser(Integer userId);

    UserWithRolesDto createUser(UserCreateDto userCreateDto);

    List<UserWithRolesDto> deleteUser(Integer userId);

    List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters);

    Optional<UserAuthenticationInfoDto> findAuthenticationInfo(String email);


}
