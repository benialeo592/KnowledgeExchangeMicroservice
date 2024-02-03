package com.beniaminoleone.booking.controller;

import com.beniaminoleone.library.dto.UserRequestDto;
import com.beniaminoleone.library.dto.UserResponseDto;
import com.beniaminoleone.booking.service.inteface.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return ResponseEntity.ok().body(this.userService.getAllUsers());
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String email){
        return ResponseEntity.ok().body(this.userService.getUserByEmail(email));
    }

    @GetMapping("/user/{roleId}")
    public  ResponseEntity<List<UserResponseDto>> getUsersByRole(@PathVariable Long roleId){
        return ResponseEntity.ok().body(this.userService.getUsersByRole(roleId));
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto userRequest){
        return ResponseEntity.ok().body(this.userService.createUser(userRequest));
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody @Valid UserRequestDto userRequest, @PathVariable  String email){
        return ResponseEntity.ok().body(this.userService.updateUser(userRequest, email));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok().body(this.userService.destroyUser(id));
    }

    @PatchMapping("/user/{email}")
    public ResponseEntity<Boolean> updateUserPassword(@RequestBody String password, @PathVariable String email){
        return ResponseEntity.ok().body(this.userService.updateUserPassword(password, email));
    }
}
