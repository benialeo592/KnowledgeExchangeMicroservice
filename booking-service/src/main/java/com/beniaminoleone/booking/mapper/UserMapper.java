package com.beniaminoleone.booking.mapper;

import com.beniaminoleone.booking.dto.UserResponseDto;
import com.beniaminoleone.booking.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto userToDto(UserEntity user);

}
