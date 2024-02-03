package com.beniaminoleone.booking.controller;

import com.beniaminoleone.library.dto.RoleRequestDto;
import com.beniaminoleone.library.dto.RoleResponseDto;
import com.beniaminoleone.booking.service.inteface.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles(){
        return ResponseEntity.ok().body(this.roleService.getAllRoles());
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable  Long id){
        return ResponseEntity.ok().body(this.roleService.getRoleById(id));
    }

    @PostMapping("/role")
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody @Valid RoleRequestDto roleRequest){
        return ResponseEntity.ok().body(this.roleService.createRole(roleRequest));
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<Boolean> deleteRole(@PathVariable Long id){
        return ResponseEntity.ok().body(this.roleService.destroyRole(id));
    }

    @PatchMapping("/role/{id}")
    public ResponseEntity<RoleResponseDto> updateRoleDescription(@RequestBody String description, @PathVariable Long id){
        return ResponseEntity.ok().body(this.roleService.updateRoleDescription(description, id));
    }


}
