package Todo.service.impl;

import Todo.dto.authentication.UserAuthenticationInfoDto;
import Todo.dto.user.UserCreateDto;
import Todo.dto.user.UserWithRolesDto;
import Todo.dto.user.filter.UserFilterDto;
import Todo.entity.Role;
import Todo.entity.User;
import Todo.repository.RoleRepository;
import Todo.repository.UserRepository;
import Todo.repository.specification.UserSpecification;
import Todo.service.UserService;
import Todo.service.factory.UserFactory;
import Todo.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JpaUserService implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final UserFactory userFactory;

    public JpaUserService(UserRepository userRepository,
                          RoleRepository roleRepository,
                          UserMapper userMapper,
                          UserFactory userFactory) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.userFactory = userFactory;
    }

    @Override
    public Integer getId(String email) {
        return userRepository.findOneByEmail(email).getId();
    }

    @Transactional
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

    @Transactional
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

    @Transactional
    @Override
    public List<UserWithRolesDto> deleteUser(Integer userId){
        User user = userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);

        return getUsers();
    }

    @Override
    public Optional<UserAuthenticationInfoDto> findAuthenticationInfo(String email) {
        Optional<User> userOpt = userRepository.findOneWithRolesByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return Optional.of(new UserAuthenticationInfoDto(
                    user.getId(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles().stream().map(Role::getCode).collect(Collectors.toSet())
            ));
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public UserWithRolesDto createUser(UserCreateDto userCreateDto){

        Collection<String> codes = new ArrayList<>();
        codes.add("user");
        Set<Role> newRoles = roleRepository.findAllByCodeIn(codes);


        User user = userFactory.build(
                userCreateDto.getFirstName(),
                userCreateDto.getLastName(),
                userCreateDto.getEmail(),
                userCreateDto.getPassword(),
                newRoles
        );

        user = userRepository.saveAndFlush(user);

        return userMapper.mapUserToUserWithRolesDto(user);
    }

}
