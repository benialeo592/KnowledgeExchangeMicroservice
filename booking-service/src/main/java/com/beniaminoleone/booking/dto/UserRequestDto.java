package com.beniaminoleone.booking.dto;

import com.beniaminoleone.booking.entity.RoleEntity;
import jakarta.validation.constraints.*;


public class UserRequestDto {

    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotNull
    @Size(max = 16, min = 6)
    private String password;
    @NotBlank
    @NotNull
    private String firstname;
    @NotBlank
    @NotNull
    private String lastname;

    @NotNull
    private Integer age;

    @NotNull
    private RoleEntity role;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public RoleEntity getRoleEntity() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRoleEntity(RoleEntity role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}
