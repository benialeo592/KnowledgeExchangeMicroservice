package com.beniaminoleone.booking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RoleRequestDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
