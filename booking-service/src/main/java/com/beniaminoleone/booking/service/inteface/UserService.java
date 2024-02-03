package com.beniaminoleone.booking.service.inteface;


import com.beniaminoleone.library.dto.UserRequestDto;
import com.beniaminoleone.library.dto.UserResponseDto;

import java.util.List;

public interface UserService{

    UserResponseDto getUserByEmail(String email);

    List<UserResponseDto> getAllUsers();
    List<UserResponseDto> getUsersByRole(Long roleId);

    UserResponseDto createUser(UserRequestDto user);

    boolean destroyUser(Long id);

    UserResponseDto updateUser(UserRequestDto user, String userEmail);

    boolean updateUserPassword(String newPassword, String userEmail);

}
