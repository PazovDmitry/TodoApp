package Todo.service.impl;

import Todo.dto.user.UserWithRolesDto;
import Todo.dto.user.filter.UserFilterDto;
import Todo.entity.Role;
import Todo.entity.User;
import Todo.repository.RoleRepository;
import Todo.repository.UserRepository;
import Todo.repository.specification.UserSpecification;
import Todo.service.UserService;
import Todo.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class JpaUserService implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public JpaUserService(UserRepository userRepository,
                          RoleRepository roleRepository,
                          UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Integer getId(String email) {
        return userRepository.findOneByEmail(email).getId();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void editRole(Integer userId, Collection<String> roleCodes) {
        User user = userRepository.findById(userId).orElseThrow();

        Set<Role> newRoles = roleRepository.findAllByCodeIn(roleCodes);

        user.setRoles(newRoles);

        userRepository.save(user);
    }

    @Override
    public List<UserWithRolesDto> getUsers() {
        List<User> users = userRepository.findAllWithRoles();
        return userMapper.mapUserToUserWithRolesDto(users);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters) {
        List<User> users = userRepository.findAll(UserSpecification.findUsers(filters));
        return userMapper.mapUserToUserWithRolesDto(users);
    }

    @Override
    public UserWithRolesDto getUser(Integer userId){
        User user = userRepository.findById(userId).orElseThrow();
        return userMapper.mapUserToUserWithRolesDto(user);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public List<UserWithRolesDto> deleteUser(Integer userId){
        User user = userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);

        return getUsers();
    }
}
