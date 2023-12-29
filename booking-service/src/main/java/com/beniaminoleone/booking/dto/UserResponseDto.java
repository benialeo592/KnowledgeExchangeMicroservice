package com.beniaminoleone.booking.dto;

import com.beniaminoleone.booking.entity.RoleEntity;


public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Integer age;
    private RoleEntity roleEntity;

    public Long getId() {
        return id;
    }

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
        return roleEntity;
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

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
