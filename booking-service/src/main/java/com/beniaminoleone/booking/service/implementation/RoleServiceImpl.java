package com.beniaminoleone.booking.service.implementation;

import com.beniaminoleone.library.dto.RoleResponseDto;
import com.beniaminoleone.booking.repository.RoleRepository;
import com.beniaminoleone.library.dto.RoleRequestDto;
import com.beniaminoleone.booking.entity.RoleEntity;
import com.beniaminoleone.booking.mapper.RoleMapper;
import com.beniaminoleone.booking.service.inteface.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepo;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepo, RoleMapper roleMapper){
        this.roleRepo = roleRepo;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleResponseDto> getAllRoles(){
        return this.roleRepo.findAll()
                .stream()
                .map(this.roleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDto getRoleById(Long id){
        return this.roleMapper.toDto(this.roleRepo.findById(id).orElseThrow(()->new RuntimeException("Role not found")));
    }
    @Override
    public RoleResponseDto createRole(RoleRequestDto roleRequest){
        RoleEntity role = new RoleEntity();
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        return this.roleMapper.toDto(this.roleRepo.save(role));
    }

    @Override
    public boolean destroyRole(Long id){
        RoleEntity foundRole = this.roleRepo.findById(id).orElseThrow(()->new RuntimeException("Role not found"));
        if(foundRole.getName().equals("Admin") || foundRole.getName().equals("User")){
            throw new RuntimeException("This role can't be destroyed");
        }
        this.roleRepo.delete(foundRole);
        return true;
    }

    @Override
    public RoleResponseDto updateRoleDescription(String description, Long id){
        RoleEntity foundRole = this.roleRepo.findById(id).orElseThrow(()->new RuntimeException("Role not found"));
        foundRole.setDescription(description);
        return this.roleMapper.toDto(this.roleRepo.save(foundRole));
    }



}
