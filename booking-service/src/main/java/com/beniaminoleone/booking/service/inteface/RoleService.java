package com.beniaminoleone.booking.service.inteface;

import com.beniaminoleone.library.dto.RoleRequestDto;
import com.beniaminoleone.library.dto.RoleResponseDto;

import java.util.List;


public interface RoleService {

    List<RoleResponseDto> getAllRoles();

    RoleResponseDto getRoleById(Long id);
    RoleResponseDto createRole(RoleRequestDto roleRequest);

    boolean destroyRole(Long id);

    RoleResponseDto updateRoleDescription(String description, Long id);
}
