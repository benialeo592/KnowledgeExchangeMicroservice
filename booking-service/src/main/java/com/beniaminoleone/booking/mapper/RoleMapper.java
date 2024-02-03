package com.beniaminoleone.booking.mapper;

import com.beniaminoleone.library.dto.RoleModel;
import com.beniaminoleone.library.dto.RoleResponseDto;
import com.beniaminoleone.booking.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponseDto toDto(RoleEntity role);

    RoleEntity toEntity(RoleModel roleModel);
}
