package com.beniaminoleone.library.dto;



public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Integer age;
    private RoleModel role;

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

    public RoleModel getRoleModel() {
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

    public void setRoleModel(RoleModel role) {
        this.role = role;
    }
}
