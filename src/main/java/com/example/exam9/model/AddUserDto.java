package com.example.exam9.model;

import com.example.exam9.entity.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddUserDto {

    @Size(max = 25)
    @NotBlank
    private String name;
    @Size(max = 25)
    @NotBlank
    private String login;
    @Size(max = 25)
    @NotBlank
    private String password;
    @Email
    @Size(max = 25)
    @NotBlank
    private String email;

    private Role role;
}
