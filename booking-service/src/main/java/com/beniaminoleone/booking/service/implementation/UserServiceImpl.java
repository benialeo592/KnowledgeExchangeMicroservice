package com.beniaminoleone.booking.service.implementation;


import com.beniaminoleone.booking.mapper.RoleMapper;
import com.beniaminoleone.library.dto.UserRequestDto;
import com.beniaminoleone.library.dto.UserResponseDto;
import com.beniaminoleone.booking.repository.UserRepository;
import com.beniaminoleone.booking.entity.UserEntity;
import com.beniaminoleone.booking.mapper.UserMapper;
import com.beniaminoleone.booking.service.inteface.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    public UserServiceImpl(UserRepository userRepo, UserMapper userMapper, RoleMapper roleMapper){
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        UserEntity foundUser = this.userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not Found"));
        return userMapper.userToDto(foundUser);
    }

    @Override
    public List<UserResponseDto> getAllUsers(){
        return this.userRepo.findAll()
                .stream()
                .map(this.userMapper::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> getUsersByRole(Long roleId) {
        return this.userRepo.findAllByRole(roleId)
                .stream()
                .map(this.userMapper::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto createUser(UserRequestDto user) {
        UserEntity newUser = new UserEntity();
        newUser.setEmail(user.getEmail());
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setPassword(user.getPassword());
        newUser.setRoleEntity(this.roleMapper.toEntity(user.getRoleModel()));
        newUser.setAge(user.getAge());
        newUser = this.userRepo.save(newUser);
        return this.userMapper.userToDto(newUser);
    }

    @Override
    public boolean destroyUser(Long id) {
        this.userRepo.delete(this.userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not Found")));
        return true;
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto user, String userEmail) {
        UserEntity foundUser = this.userRepo.findByEmail(userEmail).orElseThrow(()-> new RuntimeException("User not Found"));
        foundUser.setEmail(user.getEmail());
        foundUser.setAge(user.getAge());
        foundUser.setRoleEntity(this.roleMapper.toEntity(user.getRoleModel()));
        foundUser.setFirstname(user.getFirstname());
        foundUser.setLastname(user.getLastname());
        foundUser = this.userRepo.save(foundUser);
        return this.userMapper.userToDto(foundUser);
    }

    @Override
    public boolean updateUserPassword(String newPassword, String userEmail) {
        UserEntity foundUser = this.userRepo.findByEmail(userEmail).orElseThrow(()-> new RuntimeException("User not Found"));
        foundUser.setPassword(newPassword);
        this.userRepo.save(foundUser);
        return true;
    }

}
